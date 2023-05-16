package com.assessment.juniter.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> itemNotFoundExceptionHandler(ItemNotFoundException infe) {
        // Do something to handle the exception
        System.out.println("Custom exception handler [itemNotFoundExceptionHandler] called.");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentExceptionHandler() {
        // Do something to handle the exception
        System.out.println("Custom exception handler [illegalArgumentExceptionHandler] called.");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionException.class)
    public void transactionExceptionHandler() {
        // Do something to handle the exception
        System.out.println("Custom exception handler [transactionExceptionHandler] called.");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolationExceptionHandler() {
        // Do something to handle the exception
        System.out.println("Custom exception handler [dataIntegrityViolationExceptionHandler] called.");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
