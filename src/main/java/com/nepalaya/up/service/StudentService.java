package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.Student;

public interface StudentService {


    Response add(Student student);

    Response update(Student student);

    Response delete(Long id);

    Response getAll();

    Response getById(Long id);
}
