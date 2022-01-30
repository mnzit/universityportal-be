package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.enums.BookState;
import com.nepalaya.up.request.BookDetailRequest;
import com.nepalaya.up.request.BookHistoryRequest;

import java.util.Optional;

public interface BookService {

    Response saveBook(BookDetailRequest request);

    Response getBook(Long bookDetailId);

    Response getAllBooks();

    Response addCopy(Long bookDetailId, Integer noOfCopies);

    Response updateCopy(Long bookId, BookState state);

    Response borrowBook(BookHistoryRequest bookHistoryRequest);

    Response returnBook(BookHistoryRequest bookHistoryRequest);

    Response deleteCopy(Long bookId);
}
