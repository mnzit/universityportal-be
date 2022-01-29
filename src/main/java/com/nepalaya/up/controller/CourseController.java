package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CourseDetailRequest;
import com.nepalaya.up.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstant.COURSES)
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Response addCourse(@RequestBody @Valid CourseDetailRequest request) {
        return courseService.saveCourse(request);
    }

    @GetMapping
    public Response getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(ApiConstant.WRAPPED_ID)
    public Response getCourseById(@PathVariable(ApiConstant.ID) Long courseId) {
        return courseService.getCourse(courseId);
    }

    @DeleteMapping( ApiConstant.WRAPPED_ID)
    public Response deleteCourse(@PathVariable(ApiConstant.ID) Long courseId) {
        return courseService.deleteCourse(courseId);
    }

    @PutMapping( ApiConstant.WRAPPED_ID)
    public Response updateCourse(@PathVariable(ApiConstant.ID) Long courseId, @RequestBody CourseDetailRequest request) {
        return courseService.updateCourse(courseId, request);
    }
}
