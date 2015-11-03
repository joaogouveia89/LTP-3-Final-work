package cadastro;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;

import dados.Cliente;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

public class Cadastro {
	
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Produto> produtos = new ArrayList<Produto>();
	public static ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	private static int numRegistrosMantidos = 0;
	
	//Lista de clientes
	public static void incluirCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public static void excluirCliente(Cliente cliente){
		int index = 0;
		
		for(Cliente auxCliente : clientes){
			if(auxCliente.getCodigo() == cliente.getCodigo()){
				clientes.remove(index);
			}
			index++;
		}
	}
	
	public static Cliente buscaClientePeloCodigo(int codigo) throws SisVendasException{
		for(Cliente auxCliente : clientes){
			if(codigo == auxCliente.getCodigo()){
				return auxCliente;
			}
		}
		throw new SisVendasException("Não existe cliente para o código!");	
	}
	
	public static Cliente buscaClientePeloCpf(String cpf) throws SisVendasException{
		for(Cliente auxCliente : clientes){
			if(cpf.equals(auxCliente.getCpf())){
				return auxCliente;
			}
		}
		throw new SisVendasException("Não existe cliente para o cpf!");	
	}
	
	public static ArrayList<Cliente> listaClientesEmOrdemAlfabetica() throws SisVendasException{
		
		if(clientes.size() == 0){
			throw new SisVendasException("Não existe cliente para o cpf!");
		}
		
		Collections.sort(clientes);
		return clientes;
	}
	
	//Lista de Produtos
	public static void incluirProduto(Produto produto){
		produtos.add(produto);
	}
	
	public static void excluirProduto(Produto produto){
		int index = 0;
		
		for(Produto auxProduto : produtos){
			if(auxProduto.getCodigo() == produto.getCodigo()){
				produtos.remove(index);
			}
			index++;
		}
	}
	
	public static Produto buscaProdutoPeloCodigo(int codigo) throws SisVendasException{
			System.out.println("Size: "+produtos.size());
		for(Produto auxProduto : produtos){
			if(codigo == auxProduto.getCodigo()){
				return auxProduto;
			}
		}
		throw new SisVendasException("Não existe produto para o código!");	
	}
	
	public static ArrayList<Produto> listaProdutosEmOrdemAlfabetica() throws SisVendasException{
		
		if(produtos.size() == 0){
			throw new SisVendasException("Não existe produto para o cpf!");
		}
		
		Collections.sort(produtos);
		return produtos;
	}
	
	//Lista de Vendas
	public static void incluirVenda(Venda venda){
		vendas.add(venda);
	}
	
	public static void excluirVenda(Venda venda){
		int index = 0;
		
		for(Venda auxVenda : vendas){
			if(auxVenda.getNumVenda() == venda.getNumVenda()){
				vendas.remove(index);
			}
			index++;
		}
	}
	
	public static Venda buscaVendaPeloNumero(int numero) throws SisVendasException{
		for(Venda auxVenda : vendas){
			if(numero == auxVenda.getNumVenda() ){
				return auxVenda;
			}
		}
		throw new SisVendasException("Não existe produto para o código!");	
	}
	
	public static ArrayList<Venda> buscarVendasParaClienteEmOrdemDescendenteDoCodigoDaVenda(Cliente cliente){
		ArrayList<Venda> listaDeVendas = new ArrayList<Venda>();
		for(Venda venda: vendas){
			if(venda.getCliente().getCodigo() == cliente.getCodigo()){
				listaDeVendas.add(venda);
			}
		}
		
		return listaDeVendas;
	}
	
	public static ArrayList<Venda> buscarVendasEmOrdemDoNomeDoClienteEDataDaVenda(GregorianCalendar dataInicio, GregorianCalendar dataFim){
		ArrayList<Venda> vendasPeriodo = new ArrayList<Venda>();
		
		//Verifica se a data esta no intervalo do periodo
		for(Venda venda: vendas){
			if((venda.getDataVenda().compareTo(dataInicio) >= 0) && (venda.getDataVenda().compareTo(dataFim) <= 0)){
				vendasPeriodo.add(venda);
			}
		}
		
		
		
		return vendasPeriodo;
	}
	
	//Métodos de backup
	
	public static void carregarClientes(){
		
		try{
			File file = new File("database/clientes.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader("database/clientes.txt"));
			int i = 1;
			while(true){				
				String linha = reader.readLine();
				if(linha == null) break;
				
				// recuperando os dados
				int codigo = Integer.parseInt(linha.substring(0,5));
				String nome = linha.substring(5, 65).trim();
				String cpf = linha.substring(65,125).trim();
				String telefone = linha.substring(125,185).trim();
				String email = linha.substring(185,245).trim();
				String dtInclusaoStr = linha.substring(245,305).trim();
				String dtAlteracaoStr = linha.substring(305).trim();
				
				int ano;
				int mes;
				int dia;
				if(dtInclusaoStr.charAt(6) == ','){	
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtInclusaoStr.substring(5,6));
					dia = Integer.parseInt(dtInclusaoStr.substring(7));
				}
				else{
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtInclusaoStr.substring(5,7));
					dia = Integer.parseInt(dtInclusaoStr.substring(8));
				}
				
				GregorianCalendar dtInclusao = new GregorianCalendar(ano,mes,dia);
				
				if(dtAlteracaoStr.charAt(6) == ','){
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtAlteracaoStr.substring(5,6));
					dia = Integer.parseInt(dtAlteracaoStr.substring(7));
				}
				else{
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtAlteracaoStr.substring(5,7));
					dia = Integer.parseInt(dtAlteracaoStr.substring(8));
				}
				
				GregorianCalendar dataUltAlteracao = new GregorianCalendar(ano,mes,dia);
				
				
				Cliente auxCliente = new Cliente(codigo, cpf, nome, telefone, email, dtInclusao, dataUltAlteracao);
				clientes.add(auxCliente);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static void atualizarClientes(){
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("database/clientes.txt"));
				for(Cliente auxClient: clientes){
					String codigo = String.valueOf(auxClient.getCodigo());
					int zerosEsquerda = 5 - codigo.length();
					for (int i=1; i <= zerosEsquerda; i++) codigo = "0" + codigo;
					String nome = auxClient.getNome();
					int espacosDireita = 60 - nome.length();
					for (int i=1; i <= espacosDireita; i++) nome += " ";
					String cpf = auxClient.getCpf();
					espacosDireita = 60 - cpf.length();
					for (int i=1; i <= espacosDireita; i++) cpf += " ";
					String telefone = auxClient.getTelefone();
					espacosDireita = 60 - telefone.length();
					for (int i=1; i <= espacosDireita; i++) telefone += " ";
					String email = auxClient.getEmail();
					espacosDireita = 60 - email.length();
					for (int i=1; i <= espacosDireita; i++) email += " ";
					GregorianCalendar dtInclusaoObj = auxClient.getDataInclusao();
					String dtInclusao = ""+dtInclusaoObj.get(Calendar.YEAR)+","+(dtInclusaoObj.get(Calendar.MONTH))+","+dtInclusaoObj.get(Calendar.DAY_OF_MONTH);
					espacosDireita = 60 - dtInclusao.length();
					for (int i=1; i <= espacosDireita; i++) dtInclusao += " ";
					GregorianCalendar dataUltAlteracaoObj = auxClient.getDataUltAlteracao();
					String dataUltAlteracao = ""+dataUltAlteracaoObj.get(Calendar.YEAR)+","+(dataUltAlteracaoObj.get(Calendar.MONTH))+","+dataUltAlteracaoObj.get(Calendar.DAY_OF_MONTH);
					
					writer.write(codigo+nome+cpf+telefone+email+dtInclusao+dataUltAlteracao+"\n");
				}
				writer.close();
			
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
						
		}
	
	public static void carregarProdutos(){
		try{
			File file = new File("database/produtos.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader("database/produtos.txt"));
			int i = 1;
			while(true){				
				String linha = reader.readLine();
				if(linha == null) break;
				
				// recuperando os dados
				int codigo = Integer.parseInt(linha.substring(0,5));
				String nome = linha.substring(5, 65).trim();
				String precoUnitarioStr = linha.substring(65,125).trim();
				
				double precoUnitario = Double.parseDouble(precoUnitarioStr);
				
				String dtInclusaoStr = linha.substring(125,185).trim();
				String dtAlteracaoStr = linha.substring(185).trim();
				
				int ano;
				int mes;
				int dia;
				if(dtInclusaoStr.charAt(6) == ','){	
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtInclusaoStr.substring(5,6));
					dia = Integer.parseInt(dtInclusaoStr.substring(7));
				}
				else{
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtInclusaoStr.substring(5,7));
					dia = Integer.parseInt(dtInclusaoStr.substring(8));
				}
				
				GregorianCalendar dtInclusao = new GregorianCalendar(ano,mes,dia);
				
				if(dtAlteracaoStr.charAt(6) == ','){
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtAlteracaoStr.substring(5,6));
					dia = Integer.parseInt(dtAlteracaoStr.substring(7));
				}
				else{
					ano = Integer.parseInt(dtInclusaoStr.substring(0,4));
					mes = Integer.parseInt(dtAlteracaoStr.substring(5,7));
					dia = Integer.parseInt(dtAlteracaoStr.substring(8));
				}
				
				GregorianCalendar dataUltAlteracao = new GregorianCalendar(ano,mes,dia);
				
				
				Produto auxProduto = new Produto(codigo, nome, precoUnitario, dtInclusao, dataUltAlteracao);
				
				produtos.add(auxProduto);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static void atualizarProdutos(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("database/produtos.txt"));
			for(Produto auxProduto: produtos){
				String codigo = String.valueOf(auxProduto.getCodigo());
				int zerosEsquerda = 5 - codigo.length();
				for (int i=1; i <= zerosEsquerda; i++) codigo = "0" + codigo;
				String nome = auxProduto.getNome();
				int espacosDireita = 60 - nome.length();
				for (int i=1; i <= espacosDireita; i++) nome += " ";
				String precoUnitario = String.valueOf(auxProduto.getPrecoUnitario());
				espacosDireita = 60 - precoUnitario.length();
				for (int i=1; i <= espacosDireita; i++) precoUnitario += " ";
				GregorianCalendar dtInclusaoObj = auxProduto.getDataInclusao();
				String dtInclusao = ""+dtInclusaoObj.get(Calendar.YEAR)+","+(dtInclusaoObj.get(Calendar.MONTH))+","+dtInclusaoObj.get(Calendar.DAY_OF_MONTH);
				espacosDireita = 60 - dtInclusao.length();
				for (int i=1; i <= espacosDireita; i++) dtInclusao += " ";
				GregorianCalendar dataUltAlteracaoObj = auxProduto.getDataUltAlteracao();
				String dataUltAlteracao = ""+dataUltAlteracaoObj.get(Calendar.YEAR)+","+(dataUltAlteracaoObj.get(Calendar.MONTH))+","+dataUltAlteracaoObj.get(Calendar.DAY_OF_MONTH);
				
				writer.write(codigo+nome+precoUnitario+dtInclusao+dataUltAlteracao+"\n");
			}
			writer.close();
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}
