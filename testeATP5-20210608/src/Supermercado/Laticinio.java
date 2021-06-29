package Supermercado;

public class Laticinio extends Produto {
	private static final long serialVersionUID = 1L;
	private String tipoLaticinio;
	private static String[] opcLaticinio = { "Queijos", "Leites", "Iogurtes" };

	public Laticinio(int codigo, String nome, String fornecedor, String especificacao) {
		super(codigo, nome, fornecedor);
		this.tipoLaticinio = especificacao;
		this.categoria = "Laticínio";
	}

	public String getLaticinio() {
		return this.tipoLaticinio;
	}

	@Override 
	public String toString() {
		return super.toString() + "Tipo de Laticínio: " + this.tipoLaticinio + "\n";
	}

	public static String[] getOpcLaticinio() {
		return opcLaticinio;
	}

}