package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
public class BookHistoryRequest implements Serializable {

    @Min(1)
    private long bookDetailId;
    @Email(message = "Email format is incorrect!")
    private String email;
    @NotBlank(message = "Should not be blank!")
    @Pattern(regexp = "return|borrow", message = "Only return or borrow is acceptable!")
    private String type;
}
