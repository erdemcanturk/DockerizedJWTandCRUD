package com.erdem.dockerizedcrud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.security"})
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.service"})
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.model"})
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.controller"})
@EnableSwagger2

public class DockerizedCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerizedCrudApplication.class, args);
    }




}
