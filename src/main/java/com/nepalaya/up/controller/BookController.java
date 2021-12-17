package com.nepalaya.up.controller;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.repository.BookDetailRepository;
import com.nepalaya.up.repository.BookHistoryRepository;
import com.nepalaya.up.response.BookDetailResponse;
import com.nepalaya.up.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public BookController(BookDetailRepository bookDetailRepository,
                            BookHistoryRepository bookHistoryRepository
                           ) {
        this.bookDetailRepository = bookDetailRepository;
        this.bookHistoryRepository = bookHistoryRepository;

    }

    @GetMapping
    public List<BookDetail> books(){
        List<BookDetail> bookDetails = bookDetailRepository.findAll();
        return bookDetails;
    }

    @GetMapping("/histories/{bookId}")
    public List<BookHistory> bookHistory(@PathVariable("bookId") Long bookId){
        List<BookHistory> bookHistories = bookHistoryRepository.findBookHistoriesByBook(new Book(bookId));
        return bookHistories;
    }


  }



