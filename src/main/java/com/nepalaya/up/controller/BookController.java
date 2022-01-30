package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.enums.BookState;
import com.nepalaya.up.request.BookDetailRequest;
import com.nepalaya.up.request.BookHistoryRequest;
import com.nepalaya.up.request.enums.BookHistoryEnum;
import com.nepalaya.up.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * POST -> localhost:8080/UniversityPortal/books
 * GET -> localhost:8080/UniversityPortal/books/1
 * GET -> localhost:8080/UniversityPortal/books
 * POST -> localhost:8080/UniversityPortal/books/2/copy
 * PUT -> localhost:8080/UniversityPortal/books/copy/2?state=STOLEN
 * DELETE -> localhost:8080/UniversityPortal/books/copy/2
 * POST -> localhost:8080/UniversityPortal/books/action
 */
@RestController
@RequestMapping(ApiConstant.BOOKS)
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Response addBookDetail(@RequestBody @Valid BookDetailRequest request) {
        return bookService.saveBook(request);
    }

    @GetMapping
    public Response getAllBookDetails() {
        return bookService.getAllBooks();
    }

    @GetMapping(ApiConstant.WRAPPED_ID)
    public Response getBookDetailById(@PathVariable(ApiConstant.ID) Long bookDetailId) {
        return bookService.getBook(bookDetailId);
    }

    @PostMapping({ApiConstant.WRAPPED_ID + ApiConstant.COPY, ApiConstant.WRAPPED_ID + ApiConstant.COPY + ApiConstant.NUMBER})
    public Response addBookCopy(@PathVariable(ApiConstant.ID) Long bookDetailId, @PathVariable("number") Optional<Integer> noOfCopies) {
        if (noOfCopies.isPresent()) {
            return bookService.addCopy(bookDetailId, noOfCopies.get());
        } else {
            return bookService.addCopy(bookDetailId, 1);
        }
    }

    @PutMapping(ApiConstant.COPY + ApiConstant.WRAPPED_ID)
    public Response updateBookCopy(@PathVariable(ApiConstant.ID) Long bookId, @RequestParam(ApiConstant.STATE) BookState state) {
        return bookService.updateCopy(bookId, state);
    }

    @DeleteMapping(ApiConstant.COPY + ApiConstant.WRAPPED_ID)
    public Response deleteBookCopy(@PathVariable(ApiConstant.ID) Long bookId) {
        return bookService.deleteCopy(bookId);
    }

    @PostMapping(ApiConstant.ACTION)
    public Response borrowBook(@RequestBody @Valid BookHistoryRequest request) {
        if (request.getType().compareTo(BookHistoryEnum.BORROW) == 0) {
            return bookService.borrowBook(request);
        } else {
            return bookService.returnBook(request);
        }
    }
}
