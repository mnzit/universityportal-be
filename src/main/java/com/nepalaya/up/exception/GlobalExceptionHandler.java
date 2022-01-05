package com.nepalaya.up.exception;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> invalidParameter(MethodArgumentNotValidException ex) {

        Map<String, Object> fielderror = new HashMap<>();
        List<FieldError>errors= ex.getFieldErrors();
        for (FieldError error : errors) {
            fielderror.put(error.getField(), error.getDefaultMessage());
        }
        Response response = ResponseBuilder.failure("Request Parameter is not Valid", fielderror);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<Response> systemException(SystemException ex) {
        Response response = ResponseBuilder.failure(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Response> dataNotFound(DataNotFoundException ex) {
        Response response = ResponseBuilder.failure(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
