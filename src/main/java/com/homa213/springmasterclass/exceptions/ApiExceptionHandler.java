package com.mahd312.springmasterclass.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException) {
        ApiException apiException = new ApiException(
                apiRequestException.getMessage(),
                null,
                apiRequestException.getCause(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        ApiException apiException = new ApiException(
                notFoundException.getMessage(),
                null,
                notFoundException,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
//        List<String> errorMessages = new ArrayList<>();
//        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
//        List<ObjectError> allErrors = bindingResult.getAllErrors();
//        for (ObjectError objectError :allErrors) {
//            errorMessages.add(objectError.getDefaultMessage());
//        }
//
//        ApiException apiException = new ApiException(
//                methodArgumentNotValidException.getMessage(),
//                errorMessages,
//                methodArgumentNotValidException.getCause(),
//                HttpStatus.BAD_REQUEST,
//                ZonedDateTime.now()
//        );
//
//        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        List<String> errorMessages = new ArrayList<>();
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        for (ConstraintViolation <?> constraintViolation :constraintViolations) {
            errorMessages.add(constraintViolation.getMessage());
        }

        ApiException apiException = new ApiException(
                null,
                errorMessages,
                constraintViolationException.getCause(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
