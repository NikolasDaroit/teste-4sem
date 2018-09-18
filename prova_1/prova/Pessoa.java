package com.teste.software.prova;


public class Pessoa {

	String nome;
	Endereco endereco;
	long cpf;
	
	
	public Pessoa(String nome, Endereco endereco, long cpf) {
		super();
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}
	public void setNome(String nome) {	
		if (nome.length() >=3 && nome.length() <=40) {			
			this.nome = nome;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setCpf(long cpf) {
		if (cpf > 0 && String.valueOf(cpf).length() <=11) {			
			this.cpf = cpf;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getInformacoes() {
		String cpfFormat = String.valueOf(this.cpf);
		while(cpfFormat.length() < 11) {
			cpfFormat ="0"+cpfFormat;
		}
		String retorno = "Nome: "+this.nome+
						 "\nCPF: "+cpfFormat+
						 "\nEndereco: "+this.endereco.getEnderecoFormatado();
		return retorno;
	}
	
}
