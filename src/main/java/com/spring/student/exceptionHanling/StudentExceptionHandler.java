package com.spring.student.exceptionHanling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(StudentException.class)
    public ResponseEntity<RestResponse<Object>> handleStudentException(StudentException ex) {

        RestResponse<Object> restResponse = new RestResponse<>();
        ApiError apiError = new ApiError(ex.getErrorMessage(), ex.getErrorCode(), ex.getHttpStatus());
        restResponse.setError(apiError);
        return new ResponseEntity<>(restResponse, ex.getHttpStatus());
    }
}
