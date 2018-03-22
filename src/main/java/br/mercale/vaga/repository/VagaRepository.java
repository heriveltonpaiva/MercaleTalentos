package br.mercale.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mercale.dominio.Vaga;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Long>{

}
