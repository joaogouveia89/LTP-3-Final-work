package dados;

import java.util.GregorianCalendar;

public class Cliente implements Comparable<Cliente>{
	
	private int codigo;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	public Cliente(int codigo, String cpf, String nome, String telefone, String email, GregorianCalendar dataInclusao,
			GregorianCalendar dataUltAlteracao) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataInclusao = dataInclusao;
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email="
				+ email + ", dataInclusao=" + dataInclusao + ", dataUltAlteracao=" + dataUltAlteracao + "]";
	}
	
	@Override
	public int compareTo(Cliente obj) {

		return nome.compareTo(obj.nome);
	}
		
}
