package com.nepalaya.up.controller;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.repository.BookDetailRepository;
import com.nepalaya.up.repository.BookHistoryRepository;
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

    private final BookDetailRepository bookDetailRepository;
    private final BookHistoryRepository bookHistoryRepository;
    private final BookHistoryService bookHistoryService;

    public BookController(BookDetailRepository bookDetailRepository,
                            BookHistoryRepository bookHistoryRepository,
                          BookHistoryService bookHistoryService) {
        this.bookDetailRepository = bookDetailRepository;
        this.bookHistoryRepository = bookHistoryRepository;
        this.bookHistoryService = bookHistoryService;
    }

    @GetMapping
    public List<BookDetail> books(){
        List<BookDetail> bookDetails = bookDetailRepository.findAll();
        return bookDetails;
    }

    @GetMapping("/histories/{bookId}")
    public List<BookHistoryResponse> bookHistory(@PathVariable("bookId") Long bookId){
     return bookHistoryService.getBookHistoryList(new Book(bookId));
    }


}

