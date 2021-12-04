package com.nepalaya.up.repository;

import com.nepalaya.up.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "UPDATE STUDENTS SET status=false WHERE id=:id", nativeQuery = true)
    void delete(Long id);
}