package br.mercale.vaga.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="Descrição é uma informação obrigatória")
	private String descricao;
	
	public Cargo() {
	}
	
	public Cargo(String d) {
		this.descricao = d;
	}
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
	
	
	
}
