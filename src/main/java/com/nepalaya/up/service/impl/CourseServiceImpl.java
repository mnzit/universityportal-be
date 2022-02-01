package com.nepalaya.up.service.impl;


import com.nepalaya.up.builder.CourseBuilder;
import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.mapper.CourseMapper;
import com.nepalaya.up.model.Course;
import com.nepalaya.up.repository.CourseRepository;
import com.nepalaya.up.request.CourseDetailRequest;
import com.nepalaya.up.response.CourseResponse;
import com.nepalaya.up.service.CourseService;
import com.nepalaya.up.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.nepalaya.up.constant.ExceptionConstant.*;

@Slf4j
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Response saveCourse(CourseDetailRequest request) {
        LogUtil.info("[SERVICE]: Saving course");
        try {
            Integer courseCount = courseRepository.findCourseCountByTitle(request.getTitle());
            System.out.println("courseCount: " + courseCount);

            if (courseCount > 0) {
                throw DATA_ALREADY_EXIST
                        .apply("Course already exist with the given title")
                        .get();
            }
            Course course = CourseBuilder.buildCourse(request);
            courseRepository.save(course);
            return ResponseBuilder.success("Course added successfully!");
        } catch (Exception ex) {
            throw new SystemException();

        }
    }

    @Override
    public Response getCourse(Long courseId) {
        LogUtil.info("[SERVICE]: Fetching course");
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(DATA_NOT_FOUND
                        .apply("Course not found!"));
        try {
            CourseResponse courseResponse = CourseMapper.mapCourse(course);
            return ResponseBuilder.success("Course detail fetched successfully", courseResponse);
        } catch (Exception ex) {
            throw SYSTEM_EXCEPTION.apply(null).get();
        }
    }

    @Override
    public Response getAllCourses() {
        LogUtil.info("[SERVICE]: Fetching courses");
        try {
            List<CourseResponse> courseResponses = courseRepository.findAllCourses()
                    .stream()
                    .map(CourseMapper::mapCourse)
                    .collect(Collectors.toList());
            return ResponseBuilder.success("Course details fetched successfully", courseResponses);
        } catch (Exception ex) {
            throw SYSTEM_EXCEPTION.apply(null).get();
        }
    }

    @Override
    public Response updateCourse(Long courseId, CourseDetailRequest request) {
        LogUtil.info("[SERVICE]: Updating course");
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(DATA_NOT_FOUND.apply("Course not found"));

        if (!course.getTitle().equals(request.getTitle())) {
            Integer courseCount = courseRepository.findCourseCountByTitle(request.getTitle());
            System.out.println("count: " + courseCount);
            if (courseCount > 0) {
                throw DATA_ALREADY_EXIST
                        .apply("Course already exist with the given title").get();
            }
        }

        try {
            Course updatedCourse = CourseBuilder.buildCourseUpdate(course, request);
            courseRepository.save(updatedCourse);
            return ResponseBuilder.success("Course updated successfully");
        } catch (Exception ex) {
            throw SYSTEM_EXCEPTION.apply(null).get();
        }
    }

    @Override
    public Response deleteCourse(Long courseId) {
        LogUtil.info("[SERVICE]: Deleting course");
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(DATA_NOT_FOUND.apply("Course not found"));
        try {
            course.setStatus(false);
            courseRepository.save(course);
            return ResponseBuilder.success("Course deleted successfully");
        } catch (Exception exception) {
            throw SYSTEM_EXCEPTION.apply(null).get();
        }
    }
}
