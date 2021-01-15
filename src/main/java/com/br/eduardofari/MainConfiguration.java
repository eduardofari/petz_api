package com.br.eduardofari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Producao
public class MainConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando em ambiente de produção");
        };
    }

}
