package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.mapper.BookHistoryMapper;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.repository.BookHistoryRepository;
import com.nepalaya.up.response.BookHistoryResponse;
import com.nepalaya.up.service.BookHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookHistoryServiceImpl implements BookHistoryService {

    private final BookHistoryRepository bookHistoryRepository;

    public BookHistoryServiceImpl(BookHistoryRepository bookHistoryRepository) {
        this.bookHistoryRepository = bookHistoryRepository;
    }

    @Override
    public Response getBookHistoryList(Long bookId) {
        List<BookHistory> bookHistories = bookHistoryRepository.findBookHistoriesByBook(bookId);
        if(bookHistories.isEmpty()){
           return ResponseBuilder.failure("Book history not found");
        }else{
            List<BookHistoryResponse> data = BookHistoryMapper.mapData(bookHistories);
            return ResponseBuilder.success("Book history retrieved successfully", data);
        }
    }
}
