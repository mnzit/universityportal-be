package com.nepalaya.up.request;

import com.nepalaya.up.model.enums.DurationType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Getter
@Setter
public class CourseDetailRequest implements Serializable {

    @NotEmpty(message = "Title is required!")
    private String title;

    @NotEmpty(message = "Description is required!")
    private String description;

    @NotNull
    private Double duration;

    private DurationType durationType;

    @NotNull
    private Long creditHrPerSemester;

    @NotNull
    private Long semester;

}
