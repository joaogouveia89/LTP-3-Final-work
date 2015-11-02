package cadastro;

import java.util.ArrayList;
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
}
