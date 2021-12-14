package com.nepalaya.up.controller;

import com.nepalaya.up.model.BookRecord;
import com.nepalaya.up.repository.BookRecordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bookRecord")
public class BookRecordController {

    private final BookRecordRepository bookRecordRepository;

    public BookRecordController(BookRecordRepository bookRecordRepository) {
        this.bookRecordRepository = bookRecordRepository;
    }

    @GetMapping
    public List<BookRecord> bookRecord(){
        List<BookRecord> bookRecords = bookRecordRepository.findAll();
        return bookRecords;

    }
}
