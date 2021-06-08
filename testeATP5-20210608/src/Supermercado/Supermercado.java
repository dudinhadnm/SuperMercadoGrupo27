package Supermercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//import Supermercado.Limpeza;
//import Supermercado.Bebida;
//import Supermercado.Laticinio;
//import Supermercado.Produto;
//import Supermercado.Supermercado;


public class Supermercado {
	private ArrayList<Produto> produtos;

	public Supermercado() {
		this.produtos = new ArrayList<Produto>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Cadastre o " + dadosIn[i]+ ": \n\n");

		return dadosOut;
	}
	
	public Limpeza leLimpeza (){
		int j = 1;
		String [] valores = leValores (Produto.getInfoProduto());
		String menu = "QUAL O TIPO DE PRODUTO DE LIMPEZA?\n\n" +
				"Opções:\n"; 
		for (String i : Limpeza.getOpcLimpeza()) {
			menu += j + ". "+i+"\n";
			j+=1;
		}
		String entrada = JOptionPane.showInputDialog (menu + "\n\n");
		int opc = this.retornaInteiro(entrada);
		String especificacao = Limpeza.getOpcLimpeza()[opc-1];
		
		int codigo = this.retornaInteiro(valores[0]);

		Limpeza limpeza = new Limpeza (codigo, valores[1],valores[2],especificacao);
		return limpeza;
	}
	
	public Bebida leBebida (){
		int j = 1;
		String [] valores = leValores (Produto.getInfoProduto());
		String menu = "QUAL O TIPO DE BEBIDA?\n\n" +
				"Opções:\n"; 
		for (String i : Bebida.getOpcBebida()) {
			menu += j + ". "+i+"\n";
			j+=1;
		}
		String entrada = JOptionPane.showInputDialog (menu + "\n\n");
		int opc = this.retornaInteiro(entrada);
		String especificacao = Bebida.getOpcBebida()[opc-1];

		int codigo = this.retornaInteiro(valores[0]);

		Bebida bebida = new Bebida (codigo, valores[1],valores[2], especificacao);
		return bebida;
	}

	public Laticinio leLaticinio (){
		int j = 1;
		String [] valores = leValores (Produto.getInfoProduto());
		String menu = "QUAL O TIPO DE LATICÍNIO?\n\n" +
				"Opções:\n"; 
		for (String i : Laticinio.getOpcLaticinio()) {
			menu += j + ". "+i+"\n";
			j+=1;
		}
		String entrada = JOptionPane.showInputDialog (menu + "\n\n");
		int opc = this.retornaInteiro(entrada);
		String especificacao = Laticinio.getOpcLaticinio()[opc-1];

		int codigo = this.retornaInteiro(valores[0]);

		Laticinio laticinio = new Laticinio (codigo, valores[1],valores[2], especificacao);
		return laticinio;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // Não conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Enquanto não for possível converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaProdutos (ArrayList<Produto> produtos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\supermercado.dados"));
			for (int i=0; i < produtos.size(); i++)
				outputStream.writeObject(produtos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Produto> recuperaProdutos (){
		ArrayList<Produto> produtosTemp = new ArrayList<Produto>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\supermercado.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Produto) {
					produtosTemp.add((Produto) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com produtos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return produtosTemp;
		}
	}

	public void menuSupermercado (){

		String menu = "";
		String entrada, entrada2;
		int opc1, opc2;
		boolean salvo = false;

		do {
			menu = "Controle Supermercado\n" +
					"Escolha uma das opções abaixo:\n" + 
					"1. Cadastrar Produtos\n" +
					"2. Exibir Produtos\n" +
					"3. Limpar Produtos\n" +
					"4. Gravar Produtos\n" +
					"5. Recuperar Produtos\n" +
					"9. Sair do programa";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Cadastro de Produtos\n" +
						"Qual categoria de produto você gostaria de cadastrar?:\n" + 
						"1. Limpeza\n" +
						"2. Bebida\n" +
						"3. Laticínio\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: produtos.add((Produto)leLimpeza());
				break;
				case 2: produtos.add((Produto)leBebida());
				break;
				case 3: produtos.add((Produto)leLaticinio());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Opção inválida!");
				}

				break;
			case 2: // Exibir dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Primeiro cadastre algum produto no sistema.");
					break;
				}
				String dados = "";
				for (int i=0; i < produtos.size(); i++)	{
					dados += produtos.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Primeiro cadastre algum produto no sistema.");
					break;
				}
				produtos.clear();
				salvo = false;
				JOptionPane.showMessageDialog(null,"Os produtos foram apagados com sucesso!");
				break;
			case 4: // Grava Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Primeiro cadastre algum produto no sistema.");
					break;
				}
				salvaProdutos(produtos);
				salvo = true;
				JOptionPane.showMessageDialog(null,"Produtos salvos com sucesso!");
				break;
			case 5: // Recupera Dados
				produtos = recuperaProdutos();
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem produtos para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Os produtos foram recuperados com sucesso!");
				break;
			case 9:
				if(salvo) {
					JOptionPane.showMessageDialog(null,"Fim do aplicativo SUPERMERCADO");
				} else {
					entrada2 = JOptionPane.showInputDialog("Você tem certeza que gostaria de sair sem salvar seus produtos?", "Não");
					if (entrada2.equals("Não")) {
						opc1 = 7;
					} else {
						JOptionPane.showMessageDialog(null,"Fim do aplicativo SUPERMERCADO");
					}
				}
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		Supermercado supermercado = new Supermercado ();
		supermercado.menuSupermercado();

	}

}
