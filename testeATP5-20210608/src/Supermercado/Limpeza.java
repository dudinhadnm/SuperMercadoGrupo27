package Supermercado;

public class Limpeza extends Produto{
	private static final long serialVersionUID = 1L;
	private String tipoLimpeza;
	private static String[] opcLimpeza = {"Sabão", "Desinfetante", "Detergente"};
	
	public Limpeza(int codigo, String nome, String fornecedor, String especificacao) {
		super(codigo, nome, fornecedor);
		this.tipoLimpeza = especificacao;
		this.categoria = "Limpeza";
	}
	public String getLimpeza() {
		return this.tipoLimpeza;
	}
	public String toString() {
		return super.toString() + "Tipo de Limpeza: " + this.tipoLimpeza + "\n";
	}
	public static String[] getOpcLimpeza() {
		return opcLimpeza;
	}

}
