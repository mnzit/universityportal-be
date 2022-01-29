package com.nepalaya.up.mapper;

import com.nepalaya.up.model.BaseEntity;
import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.model.enums.BookState;
import com.nepalaya.up.response.BookDetailResponse;

import java.util.stream.Collectors;

public class BookDetailMapper {

    public static BookDetailResponse mapBookDetail(BookDetail bookDetail) {

        BookDetailResponse response = new BookDetailResponse();
        response.setId(bookDetail.getId());
        response.setTitle(bookDetail.getTitle());
        response.setAuthor(bookDetail.getAuthor());
        response.setPublishedDate(bookDetail.getPublishedDate());
        response.setIsbn(bookDetail.getIsbn());


        int available = 0, taken = 0, damaged = 0, lost = 0, stolen = 0, newCount = 0;
        BookState bookState;
        bookDetail.setBooks(bookDetail.getBooks().stream().filter(BaseEntity::getStatus).collect(Collectors.toList()));
        response.setTotalCount(bookDetail.getBooks() != null ? bookDetail.getBooks().size() : 0);
        for (Book book : bookDetail.getBooks()) {

            bookState = book.getState();

            switch (bookState) {

                case AVAILABLE:
                    available = available + 1;
                    break;
                case TAKEN:
                    taken = taken + 1;
                    break;
                case LOST:
                    lost = lost + 1;
                    break;
                case STOLEN:
                    stolen = stolen + 1;
                    break;
                case DAMAGED:
                    damaged = damaged + 1;
                    break;
                case NEW:
                    newCount = newCount + 1;
                    break;
            }
        }

        response.setAvailableCount(available);
        response.setTakenCount(taken);
        response.setDamagedCount(damaged);
        response.setLostCount(lost);
        response.setStolenCount(stolen);
        response.setNewCount(newCount);

        return response;
    }
}
