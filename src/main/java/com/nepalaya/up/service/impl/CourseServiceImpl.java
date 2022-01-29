package com.nepalaya.up.service.impl;


import com.nepalaya.up.builder.CourseBuilder;
import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.mapper.CourseMapper;
import com.nepalaya.up.model.Course;
import com.nepalaya.up.repository.CourseRepository;
import com.nepalaya.up.request.CourseDetailRequest;
import com.nepalaya.up.response.CourseResponse;
import com.nepalaya.up.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Response saveCourse(CourseDetailRequest request) {
        try {
            Course course = CourseBuilder.buildCourse(request);
            courseRepository.save(course);
            return ResponseBuilder.success("Course added successfully!");
        } catch (Exception ex) {
            throw new SystemException();
        }
    }

    @Override
    public Response getCourse(Long courseId) {
        try {
            CourseResponse courseResponse = CourseMapper.mapCourse(courseRepository
                    .findById(courseId)
                    .filter(Course::getStatus)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

            return ResponseBuilder.success("Course detail fetched successfully", courseResponse);
        } catch (Exception ex) {
            throw new SystemException();
        }
    }

    @Override
    public Response getAllCourses() {
        try {
            List<CourseResponse> courseResponses = courseRepository.findAll()
                    .stream()
                    .filter(Course::getStatus)
                    .map(CourseMapper::mapCourse)
                    .collect(Collectors.toList());
            return ResponseBuilder.success("Course details fetched successfully", courseResponses);
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response updateCourse(Long courseId,CourseDetailRequest request) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new DataNotFoundException("Course not found!"));
            Course updatedCourse = CourseBuilder.buildCourseUpdate(course,request);
            courseRepository.save(updatedCourse);
            return ResponseBuilder.success("Course updated successfully");
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
    }

    @Override
    public Response deleteCourse(Long courseId) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new DataNotFoundException("Course not found!"));
            course.setStatus(false);
            courseRepository.save(course);
            return ResponseBuilder.success("Course deleted successfully");
        } catch (Exception exception) {
            throw new SystemException(exception.getMessage());
        }
    }
}
