package com.example.service_adherent.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ELAppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<Object> handleEasyLifeException(EasyLifeException ex){

        return new ResponseEntity<>(
                new ErrorMessage(ex.getLocalizedMessage(),new Date()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
