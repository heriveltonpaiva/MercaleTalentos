package br.mercale.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.mercale.vaga.dominio.Cargo;
import br.mercale.vaga.repository.CargoRepository;
/** https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/ **/
@SpringBootApplication
@ComponentScan(value = "br.mercale")
@EntityScan("br.mercale.vaga.dominio")
@EnableJpaRepositories("br.mercale.vaga.repository")
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
    
	private static final Logger log = LoggerFactory.getLogger(Run.class);

	@Bean
	public CommandLineRunner demo(CargoRepository repository) {
		return (args) -> {
			// save a couple of customers
			//repository.save(new Cargo("Analista de Sistema"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Cargo customer : repository.findAll()) {
				System.out.println(customer.getDescricao());
			}
			log.info("");

		};
	}
    
}
