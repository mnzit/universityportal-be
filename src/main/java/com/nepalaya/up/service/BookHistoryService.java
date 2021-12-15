package com.nepalaya.up.service;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.response.BookHistoryResponse;

import java.util.List;

public interface BookHistoryService {

 List<BookHistoryResponse> getBookHistoryList(Book book);

}
