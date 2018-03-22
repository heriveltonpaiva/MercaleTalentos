package br.mercale.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado uf;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estado getUf() {
		return uf;
	}
	public void setUf(Estado uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return descricao+" - "+uf.getSigla();
	}
	
}
