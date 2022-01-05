package com.nepalaya.up.builder;

import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.request.BookDetailRequest;

public class BookBuilder {

    public static BookDetail buildBook(BookDetailRequest request){

        BookDetail bookDetail = new BookDetail();
        bookDetail.setTitle(request.getTitle());
        bookDetail.setAuthor(request.getAuthor());
        bookDetail.setPublishedDate(request.getPublishedDate());
        bookDetail.setIsbn(request.getIsbn());
        return bookDetail;
    }
}
