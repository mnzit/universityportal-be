package com.nepalaya.up.mapper;

import com.nepalaya.up.model.Course;
import com.nepalaya.up.response.CourseResponse;

public class CourseMapper {

    public static CourseResponse mapCourse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setTitle(course.getTitle());
        response.setDescription(course.getDescription());
        response.setDuration(course.getDuration());
        response.setDurationType(course.getDurationType());
        response.setCreditHrPerSemester(course.getCreditHrPerSemester());
        response.setSemester(course.getSemester());
        return response;
    }
}
