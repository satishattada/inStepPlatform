package com.infy.InStepPlatform.aspects;

import com.infy.InStepPlatform.dto.ErrorInfo;
import com.infy.InStepPlatform.exception.DuplicateDataException;
import com.infy.InStepPlatform.exception.NotFoundException;
import com.infy.InStepPlatform.exception.UserRegistrationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(UserRegistrationFailed.class)
    public ResponseEntity<ErrorInfo> registrationFailedHandler(UserRegistrationFailed ex) {
        ErrorInfo err = new ErrorInfo();
        err.setErrorCode(HttpStatus.BAD_REQUEST.value());
        err.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorInfo> NotFoundHandler(NotFoundException ex) {
        ErrorInfo err = new ErrorInfo();
        err.setErrorCode(HttpStatus.BAD_REQUEST.value());
        err.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DuplicateDataException.class)
    public ResponseEntity<ErrorInfo> DuplicateData(DuplicateDataException ex) {
        ErrorInfo err = new ErrorInfo();
        err.setErrorCode(HttpStatus.CONFLICT.value());
        err.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }

}