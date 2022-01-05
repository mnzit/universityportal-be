package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.BookDetailRequest;
import com.nepalaya.up.request.BookHistoryRequest;

public interface BookService {

    Response saveBook(BookDetailRequest request);

   // Response update(B)

    Response getBook(long bookDetailId);

    Response getAllBooks();

    Response addCopy(long bookDetailId);

    Response borrowBook(BookHistoryRequest bookHistoryRequest);

    Response returnBook(BookHistoryRequest bookHistoryRequest);
}
