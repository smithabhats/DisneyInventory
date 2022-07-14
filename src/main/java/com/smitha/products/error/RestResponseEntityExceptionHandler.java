package com.smitha.products.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(
            ProductNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status",HttpStatus.NOT_FOUND);
        body.put("message", "Sorry, unable to find the product!");
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientProductStockException.class)
    public ResponseEntity<Object> handleInsufficientProductStockException(
            InsufficientProductStockException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status",HttpStatus.FORBIDDEN);
        body.put("message", "Sorry, unable to book the product due to insufficient stock!");
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }

}
