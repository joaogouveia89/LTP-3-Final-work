package usuario;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import cadastro.Cadastro;
import dados.Cliente;
import dados.Produto;
import erros.SisVendasException;

public class Usuario {
	public static void main(String[] args) throws SisVendasException{
		char op = 'n';
		String nome,cpf,telefone,email;
		int codigo;
		double precoUnitario;
		GregorianCalendar dataInclusao,dataUltAlteracao;
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("----PRODUTO----");
		do{
			System.out.println("Codigo: ");
			codigo = leia.nextInt();
			System.out.println("Nome Produto: ");
			leia.nextLine();
			nome = leia.nextLine();
			System.out.println("Preço Unitário: ");
			precoUnitario = leia.nextDouble();
			
			dataInclusao = new GregorianCalendar();
			dataUltAlteracao = new GregorianCalendar();
			
			Produto produto = new Produto(codigo, nome, precoUnitario, dataInclusao, dataUltAlteracao);
			
			Cadastro.incluirProduto(produto);
			System.out.println("Cadastrar mais produtos? ");
			op = leia.next().charAt(0);
		}while(op=='s');
		
		int codigoEsc;
		//ArrayList<Cliente> listaAlfabetica = new ArrayList<Cliente>();
		
		System.out.println("codigo esc: ");
		codigoEsc = leia.nextInt(); 
		
		//listaAlfabetica = Cadastro.listaClientesEmOrdemAlfabetica();
		
		//System.out.println("nome: "+ resultado.getNome());
		Produto prod = Cadastro.buscaProdutoPeloCodigo(codigoEsc);
		System.out.println("Produto: " + prod.getNome());
		
	}
}
