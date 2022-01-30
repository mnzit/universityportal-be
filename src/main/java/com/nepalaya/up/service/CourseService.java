package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CourseDetailRequest;

public interface CourseService {
    Response saveCourse(CourseDetailRequest request);

    Response getCourse(Long courseId);

    Response getAllCourses();

    Response updateCourse(Long courseId,CourseDetailRequest request);

    Response deleteCourse(Long courseId);

}
