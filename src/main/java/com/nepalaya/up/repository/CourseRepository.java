package com.nepalaya.up.repository;

import com.nepalaya.up.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Override
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT s FROM Course s WHERE s.id = :courseId AND s.status = true")

    Optional<Course> findById(@Param("courseId") Long courseId);
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT s FROM Course s WHERE s.status = true")
    List<Course> findAllCourses();

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT count(s.id) FROM Course s WHERE s.title = :title AND s.status = true")
    Integer findCourseCountByTitle(@Param("title") String title);
}
