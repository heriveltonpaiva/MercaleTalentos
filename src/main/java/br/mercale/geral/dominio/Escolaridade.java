package br.mercale.geral.dominio;

public class Escolaridade {

	private int id;
	private Formacao formacao;
	private String curso;
	private String instituicao;
	private int duracaoAno; 
	private int anoConclusao;
	private SituacaoCurso situacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public int getDuracaoAno() {
		return duracaoAno;
	}
	public void setDuracaoAno(int duracaoAno) {
		this.duracaoAno = duracaoAno;
	}
	public int getAnoConclusao() {
		return anoConclusao;
	}
	public void setAnoConclusao(int anoConclusao) {
		this.anoConclusao = anoConclusao;
	}
	public SituacaoCurso getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoCurso situacao) {
		this.situacao = situacao;
	}
	
	
	
}
