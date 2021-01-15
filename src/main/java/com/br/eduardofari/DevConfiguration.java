package com.br.eduardofari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Desenvolvimento
public class DevConfiguration {

    @Bean(name="Desenvolvimento")
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando em ambiente de desenvolvimento");
        };
    }

}
