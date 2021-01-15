package com.br.eduardofari;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class vendasApplication {

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.version}")
    private String applicationVersion;

    @GetMapping("/version")
    public String version(){
        return applicationName + " - Version " + applicationVersion;
    }


    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
    }
}
