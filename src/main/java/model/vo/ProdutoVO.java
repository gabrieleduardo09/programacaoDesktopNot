package model.vo;

public class ProdutoVO {

	private String nome;
	private double preco;
	private int codigo;

	public ProdutoVO() {
		super();
	}

	public ProdutoVO(String nome, double preco, int codigo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return nome + " - " + preco + " - " + codigo;
	}

}
