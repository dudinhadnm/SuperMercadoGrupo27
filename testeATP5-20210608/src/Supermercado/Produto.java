package Supermercado;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private   int codigo;
	private   String nome;
	private   String fornecedor;
	protected String categoria;
	
	public Produto(int codigo, String nome, String fornecedor) {
		this.codigo = codigo;
		this.nome = nome;
		this.fornecedor = fornecedor;
	}

	public String toString() {
		String especificacao;
		switch(this.categoria) {
		case "Limpeza":
			especificacao = ((Limpeza)this).getLimpeza();
			break;
		case "Laticínio":
			especificacao = ((Laticinio)this).getLaticinio();
			break;
		case "Bebida":
			especificacao = ((Bebida)this).getBebida();
			break;
		default:
			especificacao = "categoria não especificada";
			break;
		}
		String retorno = "";
		retorno += "Codigo: "  	  + this.codigo + "\n";
		retorno += "Nome: "  	  + this.nome   + "\n";
		retorno += "Fornecedor: " + this.fornecedor   + "\n";
		retorno += "Categoria: "  + this.categoria  + "\n";
		retorno += "Especificação - Tipo de "+ this.categoria + ": "+ especificacao + "\n";
		return retorno;
	}
	//public abstract String soar();
}