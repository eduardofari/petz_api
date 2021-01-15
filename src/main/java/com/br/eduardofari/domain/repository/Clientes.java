package com.br.eduardofari.domain.repository;

import com.br.eduardofari.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select c from Cliente c where c.nome like %:nome%")
    List<Cliente> encontrarClientePorNome( @Param("nome") String nome);

    @Query(" delete from Cliente c where c.nome =:nome")
    @Modifying
    void deleteClienteByNome(String nome);

    boolean existsByNome(String nome);

}
