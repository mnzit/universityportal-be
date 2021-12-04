package com.nepalaya.up.controller;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.Student;
import com.nepalaya.up.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response students(){
        return studentService.getAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response create(@RequestBody @Valid Student student){
        return studentService.add(student);
    }

    @GetMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response student(@PathVariable("id") Long id){
        return studentService.getById(id);
    }
}
