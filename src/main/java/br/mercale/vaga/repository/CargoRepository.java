package br.mercale.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mercale.dominio.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long>{

}
