package Supermercado;

public class Limpeza extends Produto{
	private static final long serialVersionUID = 1L;
	private String tipoLimpeza;
	
	public Limpeza(int codigo, String nome, String fornecedor, String especificacao) {
		super(codigo, nome, fornecedor);
		this.tipoLimpeza = especificacao;
		this.categoria = "Limpeza";
	}
	public String getLimpeza() {
		return this.tipoLimpeza;
	}

}
