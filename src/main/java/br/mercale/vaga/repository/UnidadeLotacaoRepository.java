package br.mercale.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mercale.dominio.Cargo;
import br.mercale.dominio.UnidadeLotacao;

@Repository
public interface UnidadeLotacaoRepository extends CrudRepository<UnidadeLotacao, Long>{

}
