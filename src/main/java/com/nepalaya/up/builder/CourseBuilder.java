package com.nepalaya.up.builder;

import com.nepalaya.up.model.Course;
import com.nepalaya.up.request.CourseDetailRequest;

public class CourseBuilder {

    public static Course buildCourse(CourseDetailRequest request){

        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setDuration(request.getDuration());
        course.setDurationType(request.getDurationType());
        course.setCreditHrPerSemester(request.getCreditHrPerSemester());
        course.setSemester(request.getSemester());
        return course;
    }

    public static Course buildCourseUpdate(Course course, CourseDetailRequest request) {
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setDuration(request.getDuration());
        course.setDurationType(request.getDurationType());
        course.setCreditHrPerSemester(request.getCreditHrPerSemester());
        course.setSemester(request.getSemester());
        return course;
    }
}
