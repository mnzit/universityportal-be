package com.nepalaya.up.request;

import com.nepalaya.up.request.enums.BookHistoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class BookHistoryRequest implements Serializable {

    @NotNull(message = "Book detail id is required!")
    @Min(value = 1, message = "Book detail id is must be greater than zero!")
    private Long bookId;

    @NotBlank(message = "Email is required!")
    @Email(message = "Email format is incorrect!")
    private String email;

    private BookHistoryEnum type;
}
