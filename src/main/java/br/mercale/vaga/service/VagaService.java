package br.mercale.vaga.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mercale.dominio.Vaga;
import br.mercale.vaga.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repository;
	
		public List<Vaga> findByFiltros(Vaga vaga) {
	        return repository.findByFiltros(vaga);
	    }
	
		public List<Vaga> findAll() {
	        return (List<Vaga>) repository.findAll();
	    }
	 	
	 	public Vaga findById(int id) {
	        return repository.findByPrimaryKey(id);
	    } 
	 	
	    public Vaga save(Vaga vaga) {
	    	vaga.setDataCadastro(new Date());
	        return repository.save(vaga);
	    }
	     
	    public void delete(Vaga vaga) {
	        repository.delete(vaga);
	    }
	    
	    public Long totalRegistros(){
	    	return repository.count();
	    }
}
