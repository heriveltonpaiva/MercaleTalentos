package br.mercale.vaga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VagaController {

	@GetMapping("/vaga")
	public String visualizarVagas() {
		return "vaga/index";
	}

	@GetMapping("/vaga/form")
	public String iniciarCadastro() {
		return "vaga/form";
	}

	@GetMapping("/vaga/list")
	public String iniciarListagem() {
		return "vaga/list";
	}

}
