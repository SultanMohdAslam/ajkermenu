package com.ajkermenu.ajker.exception;

import com.ajkermenu.ajker.base.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public Response<Void> handelNoDataFound(ItemNotFoundException ex){
        Response<Void> response = new Response<>();
        response.setMassage(ex.getMessage());
        return response;
    }
}
