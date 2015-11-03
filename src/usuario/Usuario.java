package usuario;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import cadastro.Cadastro;
import dados.Cliente;
import dados.Produto;
import erros.SisVendasException;

public class Usuario {
	
	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) throws SisVendasException{
		char op = 'n';
		String nome,cpf,telefone,email;
		int codigo;
		double precoUnitario;
		GregorianCalendar dataInclusao,dataUltAlteracao;
		
		//Carregando base de dados
		Cadastro.carregarClientes();
		Cadastro.carregarProdutos();
		
		System.out.println("----Produto----");
		do{
			System.out.println("codigo: ");
			codigo = leia.nextInt();
			System.out.println("Nome: ");
			leia.nextLine();
			nome = leia.nextLine();
			System.out.println("preco: ");
			precoUnitario = leia.nextDouble();
			
			dataInclusao = new GregorianCalendar();
			dataUltAlteracao = new GregorianCalendar();
			
			Produto produto = new Produto(codigo, nome, precoUnitario, dataInclusao, dataUltAlteracao);
			
			Cadastro.incluirProduto(produto);
			System.out.println("Cadastrar mais PRODUTOS? ");
			op = leia.next().charAt(0);
		}while(op=='s');
		
		Cadastro.atualizarProdutos();
		
	}
}
