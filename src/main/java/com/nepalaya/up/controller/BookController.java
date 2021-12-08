package com.nepalaya.up.controller;

import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.repository.BookDetailRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookDetailRepository bookDetailRepository;

    public BookController(BookDetailRepository bookDetailRepository) {
        this.bookDetailRepository = bookDetailRepository;
    }

    @GetMapping
    public List<BookDetail> books(){
        List<BookDetail> all = bookDetailRepository.findAll();
        System.out.println(all.get(0).getBooks().size());
        return bookDetailRepository.findAll();
        // Sapana Task
        // Create a BookDetail -> Service Layer
    }
}
