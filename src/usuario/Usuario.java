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
		
		Cadastro.carregarClientes();
		
		System.out.println("----Cliente----");
		do{
			System.out.println("codigo: ");
			codigo = leia.nextInt();
			System.out.println("Nome: ");
			leia.nextLine();
			nome = leia.nextLine();
			System.out.println("telefone: ");
			telefone = leia.nextLine();
			System.out.println("cpf: ");
			cpf = leia.nextLine();
			System.out.println("email: ");
			email = leia.nextLine();
			
			dataInclusao = new GregorianCalendar();
			dataUltAlteracao = new GregorianCalendar();
			
			Cliente cliente = new Cliente(codigo, cpf, nome, telefone, email, dataInclusao, dataUltAlteracao);
			
			Cadastro.incluirCliente(cliente);
			System.out.println("Cadastrar mais clientes? ");
			op = leia.next().charAt(0);
		}while(op=='s');
		
		Cadastro.atualizarClientes();
		
	}
}
