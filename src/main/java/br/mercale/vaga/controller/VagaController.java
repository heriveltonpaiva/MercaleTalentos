package br.mercale.vaga.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import br.mercale.validator.VagaValidator;

@Controller
@RequestMapping("/vaga")
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
	
	@GetMapping("/")
	public String visualizarVagas() {
		return "index";
	}

	@GetMapping("/list")
    public ModelAndView findAll(Model model) {
		Vaga vaga = initObj();
        model.addAttribute("vaga", vaga);
		carregarComboBoxes(model);
        ModelAndView mv = new ModelAndView("/vaga/list");
        mv.addObject("vagas", service.findAll());
        return mv;
    }
	
    @RequestMapping(value="/form", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute @Valid Vaga vaga, final BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
    	
    	if(result.hasErrors()) {
    		ModelAndView mv = new ModelAndView("/vaga/form");
        	carregarComboBoxes(model);
            mv.addObject("vaga", vaga);
            return mv;
        } 
        service.save(vaga);
        initObj();
        ModelAndView mv = new ModelAndView("redirect:/vaga/list");
        mv.addObject("vagas", service.findAll());
        redirectAttributes.addFlashAttribute("msgSucesso", "Operação realizada com sucesso!");
        return mv;
    }
    
    @GetMapping("/form")
    public ModelAndView iniciarCadastro(Model model) {
        carregarComboBoxes(model);
        Vaga vaga = initObj();
        model.addAttribute("vaga", vaga);
        ModelAndView mv = new ModelAndView("/vaga/form");
        return mv;
    }
    
    @RequestMapping(value="/editar/{id}",method = RequestMethod.GET)  
    public ModelAndView preEditar(@PathVariable int id, Model model){  
    	carregarComboBoxes(model);
    	ModelAndView mv = new ModelAndView("/vaga/form");
    	mv.addObject("vaga", service.findById(id));
        return mv;
    } 
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id, RedirectAttributes redirectAttributes){  
    	service.delete(new Vaga(id));  
    	ModelAndView mv = new ModelAndView("redirect:/vaga/list");
    	redirectAttributes.addFlashAttribute("msgSucesso", "Operação realizada com sucesso!");
        return mv;
    }  

	private Vaga initObj() {
		Vaga vaga = new Vaga();
        vaga.setEtapa(new Etapa());
        vaga.setSetor(new Setor());
        vaga.setCargo(new Cargo());
        vaga.setRamo(new Ramo());
        vaga.setDataCadastro(new Date());
        vaga.setUnidadeLotacao(new UnidadeLotacao());
		return vaga;
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
	    binder.initDirectFieldAccess();
	    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.setValidator(new VagaValidator());
	}
	
	private void carregarComboBoxes(Model model) {
		model.addAttribute("cargos", (List<Cargo>) cargoDao.findAll());
        model.addAttribute("setores", (List<Setor>) setorDao.findAll());
        model.addAttribute("ramos", (List<Ramo>) ramoDao.findAll());
        model.addAttribute("etapas", (List<Etapa>) etapaDao.findAll());
        model.addAttribute("unidades", (List<UnidadeLotacao>) unidadeDao.findAll());
        List<Boolean> opcoes = new ArrayList<Boolean>();
        opcoes.add(true);
        opcoes.add(false);
        model.addAttribute("radioList", opcoes);
	}
	
}
