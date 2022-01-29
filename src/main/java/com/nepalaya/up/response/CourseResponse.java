package com.nepalaya.up.response;

import com.nepalaya.up.model.enums.DurationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String title;
    private String description;
    private Double duration;
    private DurationType durationType;
    private Long creditHrPerSemester;
    private Long semester;
}
