package com.br.eduardofari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Teste
public class TestConfiguration {

    @Bean(name="Teste")
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando em ambiente de teste");
        };
    }

}
