package com.nepalaya.up.service;

import com.fasterxml.jackson.core.SerializableString;
import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.response.BookDetailResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.List;

public class BookDetailService implements Serializable {

    int count=0;
    @GetMapping
    public BookDetailResponse books() {
        if(books().getAvailableCount() >=1){
            count++;
            System.out.println( +count+ "book are Available");
        }
        else if(books().getDamagedCount()>=0){
            count++;
            System.out.println( +count+ "book are Demaged");
        }
        else if(books().getTakenCount()>=0){
            count++;
            System.out.println( +count+ "book are Taken");
        }
        else if(books().getStolenCount()>=0){
            count++;
            System.out.println( +count+ "book are Stolen");
        }

        return books();


    }
}
