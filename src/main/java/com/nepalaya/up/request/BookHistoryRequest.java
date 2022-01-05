package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class BookHistoryRequest implements Serializable {

    @Min(1)
    private long bookDetailId;
    @Email
    private String email;
    @NotBlank(message = "you should either borrow or return book")
    private String type;
}
