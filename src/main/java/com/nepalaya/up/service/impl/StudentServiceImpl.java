package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.ResponseProcessor;
import com.nepalaya.up.model.Student;
import com.nepalaya.up.repository.StudentRepository;
import com.nepalaya.up.service.StudentService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Response add(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentRepository.save(student);
                            return ResponseBuilder.success("Student Added Successfully !");
                        }
                );
    }

    @Override
    public Response update(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentRepository.save(student);
                            return ResponseBuilder.success("Student Updated Successfully !");
                        }
                );
    }

    @Override
    public Response delete(Long id) {
        return ResponseProcessor
                .process(() -> {
                    studentRepository.delete(id);
                    return ResponseBuilder.success("Student's Deleted Successfully !");
                });
    }

    @Override
    public Response getAll() {
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student's Fetched Successfully !", IterableUtils.toList(studentRepository.findAll())));
    }

    @Override
    public Response getById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseProcessor
                    .process(() -> ResponseBuilder.success("Student Fetched Successfully !", optional.get()));
        } else {
            return ResponseProcessor
                    .process(() -> ResponseBuilder.failure("Student not found!"));
        }
    }
}
