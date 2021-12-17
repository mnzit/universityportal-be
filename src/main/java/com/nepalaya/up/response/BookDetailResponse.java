package com.nepalaya.up.response;

import com.nepalaya.up.model.BookDetail;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookDetailResponse implements Serializable {

    private String title;
    private String author;
    private Date publishedDate;
    private Long isbn;
    private Integer availableCount;
    private Integer takenCount;
    private Integer damagedCount;
    private Integer lostCount;
    private Integer stolenCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getTakenCount() {
        return takenCount;
    }

    public void setTakenCount(Integer takenCount) {
        this.takenCount = takenCount;
    }

    public Integer getDamagedCount() {
        return damagedCount;
    }

    public void setDamagedCount(Integer damagedCount) {
        this.damagedCount = damagedCount;
    }

    public Integer getLostCount() {
        return lostCount;
    }

    public void setLostCount(Integer lostCount) {
        this.lostCount = lostCount;
    }

    public Integer getStolenCount() {
        return stolenCount;
    }

    public void setStolenCount(Integer stolenCount) {
        this.stolenCount = stolenCount;
    }
}
