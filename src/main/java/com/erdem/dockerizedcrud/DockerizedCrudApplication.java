package com.erdem.dockerizedcrud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.security"})
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.service"})
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.model"})

public class DockerizedCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerizedCrudApplication.class, args);
    }




}
