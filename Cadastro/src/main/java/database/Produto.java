package database;

public class Produto {

	private int qtd;

	private String nome;

	public Produto() {
	}

	public Produto(int qtd, String nome) {
		this.qtd = qtd;
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
