package br.mercale.vaga.repository;

import java.util.List;

import br.mercale.dominio.Vaga;

public interface VagaRepositoryCustom {

	public List<Vaga> findByFiltros(Vaga vaga);
	
}
