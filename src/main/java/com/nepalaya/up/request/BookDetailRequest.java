package com.nepalaya.up.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BookDetailRequest implements Serializable {


    @NotEmpty(message = "Title is required!")
//    @Pattern(regexp = "[a-zA-Z]", message = "Only supports Alphabets!")
    private String title;


//    @Pattern(regexp = "[a-zA-Z]", message = "Only supports Alphabets!")
    @NotEmpty(message = "Author is required!")
    private String author;

    @NotNull(message = "Published Date is required!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;

    @NotNull(message = "ISBN is required!")
    private Long isbn;
}
