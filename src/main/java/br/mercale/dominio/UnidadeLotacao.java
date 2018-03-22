package br.mercale.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "unidade_lotacao")
public class UnidadeLotacao {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="Descrição é uma informação obrigatória")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	public UnidadeLotacao() {
	}
	
	public UnidadeLotacao(String d) {
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
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public String toString() {
		return descricao+" - "+cidade;
	}
	
	
}
