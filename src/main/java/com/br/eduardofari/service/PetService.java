package com.br.eduardofari.service;

import com.br.eduardofari.domain.entity.Pet;
import com.br.eduardofari.rest.controller.dto.PetDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PetService {
    Pet salvar(PetDTO dto );

    Optional<Pet> obterPets(Integer id);

    @Transactional
    void atualizaPet(Integer id, String nome, String raca, String tipo);
}
