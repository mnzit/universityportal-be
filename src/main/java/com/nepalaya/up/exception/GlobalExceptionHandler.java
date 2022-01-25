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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> invalidParameter(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getFieldErrors();

        Map<String, List<String>> errorMap = new HashMap<>();
        for (FieldError fieldError: fieldErrors){

            String field = fieldError.getField();
            List<String> errors;
            if(errorMap.containsKey(field)){
                errors = errorMap.get(field);
            }else{
                errors = new ArrayList<>();
            }
            errors.add(fieldError.getDefaultMessage());
            errorMap.put(field, errors);
        }
        Response response = ResponseBuilder.failure("Request Parameter is not valid", errorMap);
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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> unexpectedType(Exception ex) {
        Response response = ResponseBuilder.failure("System Error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
