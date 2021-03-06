package Supermercado;

public class Bebida extends Produto {
	private static final long serialVersionUID = 1L;
	private String tipoBebida;
	private static String[] opcBebida = { "Refrigerante", "Vinho", "Suco" };

	public Bebida(int codigo, String nome, String fornecedor, String especificacao) {
		super(codigo, nome, fornecedor);
		this.tipoBebida = especificacao;
		this.categoria = "Bebida";
	}

	public String getBebida() {
		return this.tipoBebida;
	}

	@Override 
	public String toString() {
		return super.toString() + "Tipo de Bebida: " + this.tipoBebida + "\n";
	}

	public static String[] getOpcBebida() {
		return opcBebida;
	}

}
