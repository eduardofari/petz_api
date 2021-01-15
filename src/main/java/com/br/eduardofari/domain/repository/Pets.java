package com.br.eduardofari.domain.repository;

import com.br.eduardofari.domain.entity.Cliente;
import com.br.eduardofari.domain.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Pets extends JpaRepository<Pet, Integer> {

    @Query(value = "select p from Pet p where p.nome like %:nome%")
    List<Pet> encontrarPetPorNome( @Param("nome") String nome);

    @Query(" delete from Pet p where p.nome =:nome")
    @Modifying
    void deletePetByNome(String nome);

    List<Pet> findByCliente(Cliente cliente);

    @Query("select p from Pet p left join fetch p.cliente where p.id = :id")
    Optional<Pet> findByIdFetchCliente(@Param("id") Integer id);
}
