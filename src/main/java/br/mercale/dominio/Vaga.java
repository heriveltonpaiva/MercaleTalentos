package br.mercale.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vaga")
public class Vaga {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String codigo;
	
	private String descricao;
	
	private double salario;
	
	@Column(name = "carga_horaria")
	private int cargaHoraria;
	
	private boolean vagaAberta;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_final")
	private Date dataFinal;
	
	private String observacao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "id_setor")
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "id_etapa")
	private Etapa etapa;
	
	@ManyToOne
	@JoinColumn(name = "id_ramo")
	private Ramo ramo;
	
	@ManyToOne
	@JoinColumn(name = "id_unidade_lotacao")
	private UnidadeLotacao unidadeLotacao;
	
	public Vaga() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public boolean isVagaAberta() {
		return vagaAberta;
	}

	public void setVagaAberta(boolean vagaAberta) {
		this.vagaAberta = vagaAberta;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
	public Ramo getRamo() {
		return ramo;
	}
	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}
	public UnidadeLotacao getUnidadeLotacao() {
		return unidadeLotacao;
	}
	public void setUnidadeLotacao(UnidadeLotacao unidadeLotacao) {
		this.unidadeLotacao = unidadeLotacao;
	}
	
}
