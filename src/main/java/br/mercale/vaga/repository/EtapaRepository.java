package br.mercale.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mercale.dominio.Etapa;

@Repository
public interface EtapaRepository extends CrudRepository<Etapa, Long>{

}
