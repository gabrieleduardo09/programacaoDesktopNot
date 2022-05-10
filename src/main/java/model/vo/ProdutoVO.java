package model.vo;

public class ProdutoVO {

	private int id;
	private String nome;
	private float preco;
	private short codigo;

	public ProdutoVO() {
		super();
	}

	public ProdutoVO(int id, String nome, float preco, short codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return nome + " - " + preco + " - " + codigo;
	}

}
