package com.br.eduardofari.rest.controller;

import com.br.eduardofari.exception.PetException;
import com.br.eduardofari.exception.RegraException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraException(RegraException ex){
        String erro = ex.getMessage();
        return new ApiErrors(erro);
    }

    @ExceptionHandler(PetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlePetException(PetException ex){
        String erro = ex.getMessage();
        return new ApiErrors(erro);
    }
}
