package com.nepalaya.up.service;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.repository.BookHistoryRepository;
import com.nepalaya.up.response.BookHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookHistoryServiceImpl implements BookHistoryService{

    @Autowired
    private BookHistoryRepository bookHistoryRepository;

    @Override
    public List<BookHistoryResponse> getBookHistoryList(Book book) {
        List<BookHistory> bookHistories = bookHistoryRepository.findBookHistoriesByBook(book);
        List<BookHistoryResponse> bookHistoryResponseList = new ArrayList<>();

        for (BookHistory bookHistory : bookHistories) {

            BookHistoryResponse bookHistoryResponse = new BookHistoryResponse();
            bookHistoryResponse.setName(bookHistory.getUser().getFirstName()+" "+bookHistory.getUser().getMiddleName()+" "+bookHistory.getUser().getLastName());
            bookHistoryResponse.setTakenDate(bookHistory.getBookTakenDate());
            bookHistoryResponse.setReturnedDate(bookHistory.getBookReturnedDate());

            bookHistoryResponseList.add(bookHistoryResponse);
        }
        return bookHistoryResponseList;
    }
}
