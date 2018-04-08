package br.mercale.vaga.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.mercale.dominio.Vaga;

@Transactional
public class VagaRepositoryImpl implements VagaRepositoryCustom{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Vaga> findByFiltros(Vaga vaga) {
		String sql = ""
				+ "SELECT v.* FROM   vaga v "
				//+ "inner join unidade_lotacao ul on ul.id = v.id_unidade_lotacao    "
				//+ "inner join ramo r on r.id = v.id_ramo  "
				//+ "inner join setor s on s.id = v.id_setor   "
				//+ "inner join cargo c on c.id = v.id_cargo  "
				+ "WHERE  vaga_aberta = :vagaAberta "
				+ " AND Upper(v.descricao) LIKE :descricao ";
		if(vaga.getUnidadeLotacao().getId() > 0)
				sql+= "AND v.id_unidade_lotacao = :idUnidade ";
		if(vaga.getRamo().getId() > 0)		
			sql+="AND v.id_ramo = :idRamo ";
		if(vaga.getSetor().getId() > 0)
			sql+="AND v.id_setor = :idSetor ";
		if(vaga.getCargo().getId() > 0)
			sql+= "AND v.id_cargo = :idCargo ";
		
		sql+= " ORDER BY v.codigo DESC  ";
		
		Query query = entityManager.createNativeQuery(sql, Vaga.class);
		query.setParameter("vagaAberta", vaga.isVagaAberta());
        query.setParameter("descricao", "%"+vaga.getDescricao().toUpperCase()+ "%");
        if(vaga.getUnidadeLotacao().getId() > 0)
        	query.setParameter("idUnidade", vaga.getUnidadeLotacao().getId());
        if(vaga.getRamo().getId() > 0)
        	query.setParameter("idRamo", vaga.getRamo().getId());
        if(vaga.getSetor().getId() > 0)	
        	query.setParameter("idSetor", vaga.getSetor().getId());
        if(vaga.getCargo().getId() > 0)
        	query.setParameter("idCargo", vaga.getCargo().getId());
        
        return query.getResultList();
	}

	

}
