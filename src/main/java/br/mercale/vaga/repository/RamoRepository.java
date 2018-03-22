package br.mercale.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mercale.dominio.Ramo;

@Repository
public interface RamoRepository extends CrudRepository<Ramo, Long>{

}
