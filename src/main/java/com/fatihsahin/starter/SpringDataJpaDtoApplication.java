package com.fatihsahin.starter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.fatihsahin"})//entitiyleri tara
@SpringBootApplication//bu projenin bir springboot projesi olduğunu belirtir.
@ComponentScan(basePackages =  {"com.fatihsahin"})// RestController,Service, Repository gibi annotations ların beanları taraması için.
@EnableJpaRepositories(basePackages =  {"com.fatihsahin"})//JpaRepository nin aktif olması için.
public class SpringDataJpaDtoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJpaDtoApplication.class, args);
    }

}
