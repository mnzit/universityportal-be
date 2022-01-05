package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.BookDetailRequest;
import com.nepalaya.up.request.BookHistoryRequest;
import com.nepalaya.up.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstant.BOOK)
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Response addBook(@RequestBody @Valid BookDetailRequest request) {

        return bookService.saveBook(request);
    }

    @GetMapping
    public Response getBookById(@RequestParam long bookDetailId) {
        return bookService.getBook(bookDetailId);
    }

    @GetMapping(ApiConstant.ALL)
    public Response books() {
        return bookService.getAllBooks();
    }

    @PostMapping(ApiConstant.COPY)
    public Response addBookCopy(@RequestParam long bookDetailId) {
        return bookService.addCopy(bookDetailId);
    }

    @PostMapping("action")
    public Response borrowBook(@RequestBody @Valid BookHistoryRequest request) {

        if (request.getType().equals("borrow")) {
            return bookService.borrowBook(request);
        } else {
            return bookService.returnBook(request);
        }
    }
}
