package br.mercale.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mercale.vaga.dominio.Ramo;

@Repository
public interface RamoRepository extends CrudRepository<Ramo, Long>{

}
