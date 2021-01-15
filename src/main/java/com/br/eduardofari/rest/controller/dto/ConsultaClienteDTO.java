package com.br.eduardofari.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaClienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private List<ConsultaPetDTO> pets;
}
