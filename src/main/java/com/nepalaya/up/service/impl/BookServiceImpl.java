package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.BookBuilder;
import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.mapper.BookDetailMapper;
import com.nepalaya.up.model.*;
import com.nepalaya.up.model.enums.BookState;
import com.nepalaya.up.repository.BookDetailRepository;
import com.nepalaya.up.repository.BookHistoryRepository;
import com.nepalaya.up.repository.BookRepository;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.BookDetailRequest;
import com.nepalaya.up.request.BookHistoryRequest;
import com.nepalaya.up.response.BookDetailResponse;
import com.nepalaya.up.service.BookService;
import com.nepalaya.up.util.LogUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDetailRepository bookDetailRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BookHistoryRepository bookHistoryRepository;

    public BookServiceImpl(BookDetailRepository bookDetailRepository,
                           BookRepository bookRepository,
                           UserRepository userRepository,
                           BookHistoryRepository bookHistoryRepository) {
        this.bookDetailRepository = bookDetailRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.bookHistoryRepository = bookHistoryRepository;
    }

    @Override
    public Response saveBook(BookDetailRequest request) {

        try {
            BookDetail bookDetail = BookBuilder.buildBook(request);
            bookDetailRepository.save(bookDetail);
            return ResponseBuilder.success("Book detail added successfully!");
        } catch (Exception ex) {
            throw new SystemException();
        }
    }

    @Override
    public Response getBook(Long bookDetailId) {

        try {
            BookDetailResponse bookDetailResponse = BookDetailMapper.mapBookDetail(bookDetailRepository
                    .findById(bookDetailId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

            return ResponseBuilder.success("Book detail fetched successfully", bookDetailResponse);
        } catch (Exception ex) {
            throw new SystemException();
        }
    }

    @Override
    public Response getAllBooks() {
        try {
            List<BookDetail> bookDetail = bookDetailRepository.findAll();
            if (bookDetail != null) {
                List<BookDetailResponse> bookDetailResponses = bookDetail.stream()
                        .map(BookDetailMapper::mapBookDetail)
                        .collect(Collectors.toList());
                return ResponseBuilder.success("Book details fetched successfully", bookDetailResponses);
            } else {
                return ResponseBuilder.failure("Book details not found");
            }

        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response addCopy(Long bookDetailId, Integer noOfCopies) {
        try {
            for(int i= 1; i<=noOfCopies; i++) {
                BookDetail bookDetail = bookDetailRepository.findById(bookDetailId).orElseThrow(() -> new DataNotFoundException("Book detail not found!"));
                Book book = new Book();
                book.setBookDetail(bookDetail);
                bookRepository.save(book);
            }
            return ResponseBuilder.success("Book copy created successfully");
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response updateCopy(Long bookId, BookState state) {
        try {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException("Book not found!"));
            book.setState(state);
            bookRepository.save(book);
            return ResponseBuilder.success("Book updated successfully");
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response returnBook(BookHistoryRequest request) {

        try {
            User user = userRepository
                    .findByEmailAddress(request.getEmail())
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", request.getEmail())));

            Book book = bookRepository
                    .findById(request.getBookId())
                    .filter(BaseEntity::getStatus)
                    .orElseThrow(() -> new DataNotFoundException("Book not found!"));

            if (book.getState().compareTo(BookState.TAKEN) == 0) {

                book.setState(BookState.AVAILABLE);
                bookRepository.save(book);

                BookHistory history = bookHistoryRepository.findBorrowedBook(request.getBookId(), user);
                history.setBookReturnedDate(new Date());
                bookHistoryRepository.save(history);

                return ResponseBuilder.success("Book returned successfully");
            } else {
                LogUtil.info("Book has not been borrowed yet!");
                throw new DataNotFoundException("Book has not been borrowed yet!");
            }
        } catch (Exception exception) {
            throw new SystemException(exception.getMessage());
        }
    }

    @Override
    public Response borrowBook(BookHistoryRequest request) {
        try {

            User user = userRepository
                    .findByEmailAddress(request.getEmail())
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", request.getEmail())));

            Book book = bookRepository
                    .findById(request.getBookId())
                    .filter(BaseEntity::getStatus)
                    .orElseThrow(() -> new DataNotFoundException("Book not found!"));

            if (book.getState().compareTo(BookState.AVAILABLE) == 0 || book.getState().compareTo(BookState.NEW) == 0) {

                book.setState(BookState.TAKEN);
                book = bookRepository.save(book);

                BookHistory bookHistory = new BookHistory();
                bookHistory.setBook(book);
                bookHistory.setUser(user);
                bookHistory.setBookTakenDate(new Date());
                bookHistoryRepository.save(bookHistory);

                return ResponseBuilder.success("Book successfully borrowed!");
            } else if (book.getState().compareTo(BookState.TAKEN) == 0) {
                return ResponseBuilder.success("Book is already taken!");
            } else {
                return ResponseBuilder.success("Book cannot be borrowed!");
            }

        } catch (Exception exception) {
            throw new SystemException(exception.getMessage());
        }
    }

    @Override
    public Response deleteCopy(Long bookId) {
        try {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException("Book not found!"));
            book.setStatus(false);
            bookRepository.save(book);
            return ResponseBuilder.success("Book deleted successfully");
        } catch (Exception exception) {
            throw new SystemException(exception.getMessage());
        }
    }
}
