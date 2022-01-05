package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.BookBuilder;
import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.mapper.BookDetailMapper;
import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.model.User;
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

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookDetailRepository bookDetailRepository;

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private BookHistoryRepository bookHistoryRepository;

    public BookServiceImpl(BookDetailRepository bookDetailRepository, BookRepository bookRepository, UserRepository userRepository, BookHistoryRepository bookHistoryRepository) {
        this.bookDetailRepository = bookDetailRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.bookHistoryRepository = bookHistoryRepository;
    }

    @Override
    public Response saveBook(BookDetailRequest request) {

        try {
            Book book = new Book();
            BookDetail bookDetail = BookBuilder.buildBook(request);
            bookDetail = bookDetailRepository.save(bookDetail);
            book.setBookDetail(bookDetail);
            book = bookRepository.save(book);
            return ResponseBuilder.success("book saved successfully with id :" + book.getId());
        } catch (Exception ex) {
            LogUtil.exception(ex.getMessage());
            throw new SystemException();
        }
    }

    @Override
    public Response getBook(long bookDetailId) {

        try {
            BookDetailResponse bookDetailResponse = BookDetailMapper.mapBookDetail(bookDetailRepository
                    .findById(bookDetailId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
            return ResponseBuilder.success("book fetched successfully", bookDetailResponse);
        } catch (Exception ex) {
            LogUtil.exception(ex.getMessage());
            throw new SystemException();
        }
    }

    @Override
    public Response getAllBooks() {

        try {
            List<BookDetailResponse> bookDetailResponses = bookDetailRepository.findAll()
                    .stream()
                    .map(BookDetailMapper::mapBookDetail)
                    .collect(Collectors.toList());

            return ResponseBuilder.success("books fetched successfully", bookDetailResponses);
        } catch (Exception ex) {
            LogUtil.exception("error while fetching the books");
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response addCopy(long bookDetailId) {

        try {
            BookDetail bookDetail = new BookDetail();
            bookDetail.setId(bookDetailId);

            Book book = new Book();
            book.setBookDetail(bookDetail);
            book.setState(BookState.NEW);
            bookRepository.save(book);
            return ResponseBuilder.success("book added successfully");
        } catch (Exception ex) {
            LogUtil.exception("could not add copy");
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response borrowBook(BookHistoryRequest request) {

        try {
            User user = userRepository.findByEmailAddress(request.getEmail())
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", request.getEmail())));
            BookDetail bookDetail = new BookDetail();
            bookDetail.setId(request.getBookDetailId());
            List<Book> books = bookRepository.getAvailableBooks(bookDetail);

            if (!books.isEmpty()) {
                Book borrowBook = books.get(0);
                borrowBook.setState(BookState.TAKEN);
                borrowBook = bookRepository.save(borrowBook);

                BookHistory bookHistory = new BookHistory();
                bookHistory.setBook(borrowBook);
                bookHistory.setUser(user);
                bookHistory.setBookTakenDate(new Date());
                bookHistoryRepository.save(bookHistory);
                return ResponseBuilder.success("book borrowed successfully");
            } else {
                LogUtil.exception("there are no available books with given bookdetail id");
                throw new DataNotFoundException("there are no available books in the system");
            }
        } catch (Exception exception) {

            LogUtil.exception("couldnot borrow the book");
            throw new SystemException(exception.getMessage());
        }
    }

    @Override
    public Response returnBook(BookHistoryRequest bookHistoryRequest) {

        try {
            User user = userRepository.findByEmailAddress(bookHistoryRequest.getEmail())
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", bookHistoryRequest.getEmail())));

            BookDetail bookDetail = new BookDetail();
            bookDetail.setId(bookHistoryRequest.getBookDetailId());

            BookHistory history = bookHistoryRepository.findBorrowedBook(bookDetail, user);
            if (history != null) {
                history.setBookReturnedDate(new Date());
                bookHistoryRepository.save(history);

                Book book = history.getBook();
                book.setState(BookState.AVAILABLE);

                return ResponseBuilder.success("your book has bee successfully returned");
            } else {
                LogUtil.exception("the user has not borrowed any book");
                throw new DataNotFoundException("you have not borrowed any book");
            }
        } catch (Exception exception) {
            LogUtil.exception(exception.getMessage());
            throw new SystemException(exception.getMessage());
        }

    }


}
