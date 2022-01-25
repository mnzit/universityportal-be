package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.BookDetailRequest;
import com.nepalaya.up.request.BookHistoryRequest;
import com.nepalaya.up.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * localhost:8080/UniversityPortal/books POST
 * localhost:8080/UniversityPortal/books/1 GET
 * localhost:8080/UniversityPortal/books GET
 * localhost:8080/UniversityPortal/books/copy/1 POST
 * localhost:8080/UniversityPortal/books/action POST
 */
@RestController
@RequestMapping(ApiConstant.BOOKS)
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Response addBook(@RequestBody @Valid BookDetailRequest request) {
        return bookService.saveBook(request);
    }

    @GetMapping(ApiConstant.WRAPPED_ID)
    public Response getBookById(@PathVariable(ApiConstant.ID) Long bookDetailId) {
        return bookService.getBook(bookDetailId);
    }

    @GetMapping
    public Response books() {
        return bookService.getAllBooks();
    }

    @PostMapping(ApiConstant.COPY + ApiConstant.WRAPPED_ID)
    public Response addBookCopy(@PathVariable(ApiConstant.ID) long bookDetailId) {
        return bookService.addCopy(bookDetailId);
    }

    @PostMapping(ApiConstant.ACTION)
    public Response borrowBook(@RequestBody @Valid BookHistoryRequest request) {

        if (request.getType().equals("borrow")) {
            return bookService.borrowBook(request);
        } else {
            return bookService.returnBook(request);
        }
    }
}
