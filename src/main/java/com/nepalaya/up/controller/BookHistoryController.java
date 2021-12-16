package com.nepalaya.up.controller;

import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.repository.BookHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bookHistory")
public class BookHistoryController {

    @Autowired
    private BookHistoryRepository bookHistoryRepository;

    @GetMapping("{id}")
    public List<BookHistory> historyList(@PathVariable("id") Long id){
        return bookHistoryRepository.findBookHistoriesByBook(id);
    }
}
