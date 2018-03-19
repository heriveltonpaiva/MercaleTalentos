package br.mercale.curriculo.dominio;

import java.util.List;

import br.mercale.geral.dominio.Pessoa;

public class Curriculo {

	private int id;
	private Pessoa pessoa;
	private boolean empregado;
	private String cnh;
	private boolean possuiVeiculo;
	private boolean podeViajar;
	private boolean podeMudar;
	private String miniCurriculo;
    private String objetivos;
    private PretensaoSalarial pretensao;
    private AreaInteresse areaInteresse;
    private Idioma idioma;
    private String observacao;
    private List<Experiencia> experiencias;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public boolean isEmpregado() {
		return empregado;
	}
	public void setEmpregado(boolean empregado) {
		this.empregado = empregado;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public boolean isPossuiVeiculo() {
		return possuiVeiculo;
	}
	public void setPossuiVeiculo(boolean possuiVeiculo) {
		this.possuiVeiculo = possuiVeiculo;
	}
	public boolean isPodeViajar() {
		return podeViajar;
	}
	public void setPodeViajar(boolean podeViajar) {
		this.podeViajar = podeViajar;
	}
	public boolean isPodeMudar() {
		return podeMudar;
	}
	public void setPodeMudar(boolean podeMudar) {
		this.podeMudar = podeMudar;
	}
	public String getMiniCurriculo() {
		return miniCurriculo;
	}
	public void setMiniCurriculo(String miniCurriculo) {
		this.miniCurriculo = miniCurriculo;
	}
	public String getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	public PretensaoSalarial getPretensao() {
		return pretensao;
	}
	public void setPretensao(PretensaoSalarial pretensao) {
		this.pretensao = pretensao;
	}
	public AreaInteresse getAreaInteresse() {
		return areaInteresse;
	}
	public void setAreaInteresse(AreaInteresse areaInteresse) {
		this.areaInteresse = areaInteresse;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}
	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}
    
	
}
