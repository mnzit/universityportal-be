package com.nepalaya.up.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.util.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> invalidParameter(MethodArgumentNotValidException ex) {
        LogUtil.exception(ex.getMessage());
        List<FieldError> fieldErrors = ex.getFieldErrors();

        Map<String, List<String>> errorMap = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {

            String field = fieldError.getField();
            List<String> errors;
            if (errorMap.containsKey(field)) {
                errors = errorMap.get(field);
            } else {
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
        LogUtil.exception(ex.getMessage());
        Response response = ResponseBuilder.failure(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Response> dataNotFound(DataNotFoundException ex) {
        LogUtil.exception(ex.getMessage());
        Response response = ResponseBuilder.failure(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<Response> conversionFailed(ConversionFailedException ex) {
        LogUtil.exception(ex.getMessage());
        String message = "System Error";

        List<String> errors = new ArrayList<>();

        if (ex.getTargetType().getType().isEnum()) {
            Class aClass = ex.getTargetType().getType();
            EnumSet.allOf(aClass).forEach((e) -> errors.add(e.toString()));
            message = ex.getValue() + " is not supported. Supported types are listed below";
        }

        Response response = ResponseBuilder.failure(message, errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> httpMessageNotReadableException(InvalidFormatException ex) {
        LogUtil.exception(ex.getMessage());
        String message = "System Error";

        List<String> errors = new ArrayList<>();

        if (ex.getTargetType().isEnum()) {
            Class aClass = ex.getTargetType();
            EnumSet.allOf(aClass).forEach((e) -> errors.add(e.toString()));
            message = ex.getValue() + " is not supported. Supported types are listed below";
        }

        Response response = ResponseBuilder.failure(message, errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<Response> unexpectedTypeException(UnexpectedTypeException ex) {
        LogUtil.exception(ex.getMessage());
        Response response = ResponseBuilder.failure("System Error");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
