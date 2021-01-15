package com.br.eduardofari.rest.controller;

import com.br.eduardofari.domain.entity.Cliente;
import com.br.eduardofari.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        return clientes
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente postCliente(@RequestBody Cliente cliente) {
        return clientes.save(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id) {
        clientes.findById(id)
                .map( cliente -> {clientes.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }

    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
         clientes
                .findById(id)
                .map( clienteExiste -> {
                  cliente.setId(clienteExiste.getId());
                  clientes.save(cliente);
                  return clienteExiste;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/pesquisar")
    public List<Cliente> findCliente(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }
}
