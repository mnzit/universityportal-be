package com.nepalaya.up.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BookDetailRequest implements Serializable {

    @Max(100)
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]")
    private String title;

    @Min(2)
    @Max(100)
    @Pattern(regexp = "[a-zA-Z]")
    @NotEmpty
    private String author;

    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;

    @NotEmpty
    private Long isbn;
}
