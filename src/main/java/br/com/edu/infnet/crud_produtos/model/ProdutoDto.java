package br.com.edu.infnet.crud_produtos.model;

public class ProdutoDto {

	private String nome;
	private String descricao;
	private Integer preco; 
	private Categoria categoria;
	
	public ProdutoDto(String string, String string2, int i, Categoria comida) {
	}	  
 
	public ProdutoDto(Produto produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.categoria = produto.getCategoria();
	}
	
	public Produto toProduto() {
		return new Produto(nome, descricao, preco, categoria);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	@Override
	public String toString() {
		return "ProdutoDto [nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria=" + categoria
				+ "]";
	}

	public Produto converter() {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(preco);
		produto.setCategoria(categoria);
		return produto;
	}
	
	
}
