package br.mercale.vaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.mercale.vaga.dominio.Cargo;
import br.mercale.vaga.repository.CargoRepository;

@Controller
public class CargoController {
	@Autowired
	private CargoRepository repository;
	
	@GetMapping("/cargo")
	public String cadastrar(){
		repository.save(new Cargo("Analista de Sistemas"));
		for (Cargo customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
		return "/";
	}

}
