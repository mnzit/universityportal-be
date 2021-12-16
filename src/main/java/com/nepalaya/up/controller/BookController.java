package com.nepalaya.up.controller;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.response.BookHistoryResponse;
import com.nepalaya.up.service.BookHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookHistoryService bookHistoryService;

    public BookController(BookHistoryService bookHistoryService) {
        this.bookHistoryService = bookHistoryService;
    }

    @GetMapping("/histories/{bookId}")
    public List<BookHistoryResponse> bookHistory(@PathVariable("bookId") Long bookId){
     return bookHistoryService.getBookHistoryList(new Book(bookId));
    }

}

