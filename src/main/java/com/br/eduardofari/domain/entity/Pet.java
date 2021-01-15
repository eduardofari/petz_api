package com.br.eduardofari.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "PET")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "raca")
    private String raca;

    @Column(name="tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

}
