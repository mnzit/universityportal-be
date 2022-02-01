package com.nepalaya.up.repository;

import com.nepalaya.up.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT s FROM Course s WHERE s.id = :courseId AND s.status = true")
    Course getCourseById(@Param("courseId") Long courseId);

    @Query("SELECT s FROM Course s WHERE s.status = true")
    List<Course> findAllCourses();

    @Query("SELECT count(s.id) FROM Course s WHERE s.title = :title AND s.status = true")
    Integer getTitleCount(String title);

    @Query("SELECT count(s.id) FROM Course s WHERE s.title = :title AND s.status = true")
    Integer getTitleCounts(String title);
}
