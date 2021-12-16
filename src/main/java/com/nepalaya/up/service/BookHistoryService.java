package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.Book;

public interface BookHistoryService {

 Response getBookHistoryList(Book book);

}
