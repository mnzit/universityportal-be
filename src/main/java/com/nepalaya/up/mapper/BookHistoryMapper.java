package com.nepalaya.up.mapper;

import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.response.BookHistoryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class BookHistoryMapper {

    public static List<BookHistoryResponse> mapData(List<BookHistory> histories) {
        return histories
                .stream()
                .map((bookHistory -> {
                    BookHistoryResponse bookHistoryResponse = new BookHistoryResponse();
                    bookHistoryResponse.setName(bookHistory.getUser().getFirstName()+" "+bookHistory.getUser().getMiddleName()+" "+bookHistory.getUser().getLastName());
                    bookHistoryResponse.setTakenDate(bookHistory.getBookTakenDate());
                    bookHistoryResponse.setReturnedDate(bookHistory.getBookReturnedDate());
                    return bookHistoryResponse;
                }))
                .collect(Collectors.toList());
    }
}
