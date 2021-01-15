package com.br.eduardofari.service.impl;

import com.br.eduardofari.domain.entity.Cliente;
import com.br.eduardofari.domain.entity.Pet;
import com.br.eduardofari.domain.repository.Clientes;
import com.br.eduardofari.domain.repository.Pets;
import com.br.eduardofari.exception.PetException;
import com.br.eduardofari.exception.RegraException;
import com.br.eduardofari.rest.controller.dto.PetDTO;
import com.br.eduardofari.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final Pets repository;
    private final Clientes clienteRepository;

    @Override
    @Transactional
    public Pet salvar(PetDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RegraException("Código de Cliente, não encontrado!"));

        Pet pet = new Pet();
        pet.setNome(dto.getNome());
        pet.setRaca(dto.getRaca());
        pet.setTipo(dto.getTipo());
        pet.setCliente(cliente);

        repository.save(pet);

        return pet;
    }

    @Override
    public Optional<Pet> obterPets(Integer id) {
        return repository.findByIdFetchCliente(id);
    }

    @Override
    public void atualizaPet(Integer id, String nome, String raca, String tipo) {
        repository.findById(id)
                .map(pet -> {
                    pet.setNome(nome);
                    pet.setRaca(raca);
                    pet.setTipo(tipo);
                    return repository.save(pet);
                }).orElseThrow(() -> new PetException() );
    }
}
