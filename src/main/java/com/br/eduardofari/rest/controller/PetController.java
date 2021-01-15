package com.br.eduardofari.rest.controller;

import com.br.eduardofari.domain.entity.Pet;
import com.br.eduardofari.domain.repository.Pets;
import com.br.eduardofari.rest.controller.dto.AtualizarPetDTO;
import com.br.eduardofari.rest.controller.dto.ConsultaPetDTO;
import com.br.eduardofari.rest.controller.dto.PetDTO;
import com.br.eduardofari.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private PetService service;
    private Pets pets;

    public PetController(PetService service, Pets pets) {
        this.service = service;
        this.pets = pets;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer postPet( @RequestBody PetDTO dto){
        Pet pet = service.salvar(dto);
        return pet.getId();
    }

    @GetMapping("/{id}")
    public ConsultaPetDTO getByID(@PathVariable Integer id){
        return service
                .obterPets(id)
                .map(p -> converter(p))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado!"));

    }

    @PatchMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putPet(@PathVariable Integer id, @RequestBody AtualizarPetDTO dto){
        String newNome = dto.getNome();
        String newRaca = dto.getRaca();
        String newTipo = dto.getTipo();
        service.atualizaPet(id, newNome, newRaca, newTipo);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable Integer id) {
        pets.findById(id)
                .map( pet -> {pets.delete(pet);
                    return pet;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }



    private ConsultaPetDTO converter(Pet pet){
       return ConsultaPetDTO.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .raca(pet.getRaca())
                .tipo(pet.getTipo())
                .nomeCliente(pet.getCliente().getNome())
                .cpf(pet.getCliente().getCpf())
                .build();
    }

}
