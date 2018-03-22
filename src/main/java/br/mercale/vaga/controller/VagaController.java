package br.mercale.vaga.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mercale.dominio.Cargo;
import br.mercale.dominio.Etapa;
import br.mercale.dominio.Ramo;
import br.mercale.dominio.Setor;
import br.mercale.dominio.UnidadeLotacao;
import br.mercale.dominio.Vaga;
import br.mercale.vaga.repository.CargoRepository;
import br.mercale.vaga.repository.EtapaRepository;
import br.mercale.vaga.repository.RamoRepository;
import br.mercale.vaga.repository.SetorRepository;
import br.mercale.vaga.repository.UnidadeLotacaoRepository;
import br.mercale.vaga.service.VagaService;

@Controller
public class VagaController {
	
	@Autowired
    private VagaService service;
	@Autowired
	private CargoRepository cargoDao;
	@Autowired
	private RamoRepository ramoDao;
	@Autowired
	private EtapaRepository etapaDao;
	@Autowired
	private SetorRepository setorDao;
	@Autowired
	private UnidadeLotacaoRepository unidadeDao;

	@GetMapping("/vaga")
	public String visualizarVagas() {
		return "vaga/index";
	}

	@GetMapping("/vaga/list")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/vaga/list");
        mv.addObject("vagas", service.findAll());
        return mv;
    }
	
    @RequestMapping(value="/vaga/save", method= RequestMethod.POST)
    public ModelAndView save(
    		@ModelAttribute 
    		@Valid Vaga vaga, 
    		final BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
    	
        if(result.hasErrors()) {
        	ModelAndView mv = new ModelAndView("/vaga/form");
            mv.addObject("vaga", vaga);
            return mv;
        }
        service.save(vaga);
        initObj();
        return findAll();
    }
    
    @GetMapping("/vaga/form")
    public ModelAndView iniciarCadastro(Model model) {
        model.addAttribute("cargos", (List<Cargo>) cargoDao.findAll());
        model.addAttribute("setores", (List<Setor>) setorDao.findAll());
        model.addAttribute("ramos", (List<Ramo>) ramoDao.findAll());
        model.addAttribute("etapas", (List<Etapa>) etapaDao.findAll());
        model.addAttribute("unidades", (List<UnidadeLotacao>) unidadeDao.findAll());
        
        Vaga vaga = initObj();
        model.addAttribute("vaga", vaga);

        return new ModelAndView("/vaga/form");
    }

	private Vaga initObj() {
		Vaga vaga = new Vaga();
        vaga.setEtapa(new Etapa());
        vaga.setSetor(new Setor());
        vaga.setCargo(new Cargo());
        vaga.setRamo(new Ramo());
        vaga.setUnidadeLotacao(new UnidadeLotacao());
		return vaga;
	}
	
}
