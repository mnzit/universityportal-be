package com.nepalaya.up.response;

import java.io.Serializable;
import java.util.Date;

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

}
