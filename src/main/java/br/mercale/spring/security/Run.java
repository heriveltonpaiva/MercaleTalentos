package br.mercale.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/** https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/ **/
@SpringBootApplication
@ComponentScan(value = "br.mercale")
@EntityScan("br.mercale.dominio")
@EnableJpaRepositories("br.mercale.vaga.repository")
public class Run {
    
	public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
    
	@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("validation");
        messageSource.setDefaultEncoding("ISO-8859-1");
        return messageSource;
    }
	
}
