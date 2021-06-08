package Supermercado;

import java.io.Serializable;

public abstract class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private   int codigo;
	private   String nome;
	private   String fornecedor;
	protected String categoria;
	private static String[] infoProduto = {"Código", "Nome", "Fornecedor"};
	
	public Produto(int codigo, String nome, String fornecedor) {
		this.codigo = codigo;
		this.nome = nome;
		this.fornecedor = fornecedor;
	}

	public String toString() {
		String retorno = "";
		retorno += "Codigo: "  	  + this.codigo + "\n";
		retorno += "Nome: "  	  + this.nome   + "\n";
		retorno += "Fornecedor: " + this.fornecedor   + "\n";
		retorno += "Categoria: "  + this.categoria  + "\n";
		return retorno;
	}
	public static String[] getInfoProduto() {
		return infoProduto;
	}
}