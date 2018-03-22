package br.mercale.dominio;

public class Idioma {

	private int id;
	private IdiomaNivel compreensao;
	private IdiomaNivel escrita;
	private IdiomaNivel fala;
	private IdiomaNivel leitura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IdiomaNivel getCompreensao() {
		return compreensao;
	}
	public void setCompreensao(IdiomaNivel compreensao) {
		this.compreensao = compreensao;
	}
	public IdiomaNivel getEscrita() {
		return escrita;
	}
	public void setEscrita(IdiomaNivel escrita) {
		this.escrita = escrita;
	}
	public IdiomaNivel getFala() {
		return fala;
	}
	public void setFala(IdiomaNivel fala) {
		this.fala = fala;
	}
	public IdiomaNivel getLeitura() {
		return leitura;
	}
	public void setLeitura(IdiomaNivel leitura) {
		this.leitura = leitura;
	}
	
	
}
