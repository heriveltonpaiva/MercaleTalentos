package br.mercale.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/** https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/ **/
@SpringBootApplication
@ComponentScan(value = "br.mercale")
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
