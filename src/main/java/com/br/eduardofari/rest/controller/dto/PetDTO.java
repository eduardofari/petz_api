package com.br.eduardofari.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private Integer cliente;
    private String nome;
    private String raca;
    private String tipo;


}
