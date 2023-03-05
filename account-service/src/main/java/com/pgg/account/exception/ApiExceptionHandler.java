package com.pgg.account.exception;


import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected StandardError processNotFoundException(
            final ApiException ex, final WebRequest request) {
        return StandardError.builder()
                .code(ex.getIssue().getCode())
                .message(ex.getIssue().getMessage())
                .timesTamp(System.currentTimeMillis())
                .path(request.getDescription(true))
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected StandardError processBadRequestException(
            final ApiException ex, final WebRequest request) {
        return StandardError.builder()
                .code(ex.getIssue().getCode())
                .message(ex.getIssue().getMessage())
                .timesTamp(System.currentTimeMillis())
                .path(request.getDescription(true))
                .build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected Issue handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex) {



        final List<String> errors = new ArrayList<>();

        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return new Issue(IssueType.BAD_REQUEST, errors);
    }

}