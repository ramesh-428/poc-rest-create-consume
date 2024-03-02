package com.ramesh.demoPOC1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ramesh.demoPOC1.data.pojo.ErrorResponse;

@RestControllerAdvice
public class WebServiceExceptionHandler {


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFound(ProductNotFoundException ex){
        return new ErrorResponse("ERROR", "PRODUCT_NOT_FOUND", ex.getMessage());
    }
}
