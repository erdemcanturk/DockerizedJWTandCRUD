package com.erdem.dockerizedcrud;

import com.erdem.dockerizedcrud.repository.ICustomerRepository;
import com.erdem.dockerizedcrud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.security"})
@ComponentScan(basePackages = {"com.erdem.dockerizedcrud.service"})
public class DockerizedCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerizedCrudApplication.class, args);
    }

}
