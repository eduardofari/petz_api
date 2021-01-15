package com.br.eduardofari.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaPetDTO {
    private Integer id;
    private String nome;
    private String raca;
    private String tipo;
    private String nomeCliente;
    private String cpf;

}
