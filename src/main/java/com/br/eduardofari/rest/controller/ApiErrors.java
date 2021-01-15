package com.br.eduardofari.rest.controller;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> erros;

    public ApiErrors(String erro){
        this.erros = Arrays.asList(erro);
    }
}
