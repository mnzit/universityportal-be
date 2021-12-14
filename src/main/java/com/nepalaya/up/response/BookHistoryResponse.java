package com.nepalaya.up.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BookHistoryResponse implements Serializable {

    private Date takenDate;
    private Date returnedDate;
    private String name;

}
