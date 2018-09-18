package com.teste.software.prova;


public class Endereco {

	String rua;
	String bairro;
	String complemento;
	String cidade;
	String uf;
	int numero;
	long cep;

	public Endereco(String rua, String bairro, String complemento, String cidade, String uf, int numero, long cep) {
		super();
		this.setRua(rua);
		this.setBairro(bairro);
		this.setComplemento(complemento);
		this.setCidade(cidade);
		this.setUF(uf);
		this.setNumero(numero);
		this.setCep(cep);
	}

	public void setRua(String rua) {
		if (rua.length()>= 3 && rua.length() <=30) {
			this.rua = rua;			
		}else {
			this.rua= "N.D.";
		}
	}

	public void setBairro(String bairro) {
		if (bairro.length()>= 3 && bairro.length() <=20) {
			this.bairro = bairro;			
		}else {
			this.bairro = "N.D.";
		}
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUF(String uf) {
		if (uf.length() == 2) {			
			this.uf = uf;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public void setNumero(int numero) {
		if (numero > 0) {			
			this.numero = numero;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public void setCep(long cep) {
		if (cep > 0 && String.valueOf(cep).length() <= 8) {			
			this.cep = cep;
		}else {
			throw new IllegalArgumentException();
		}

	}

	public String getEnderecoFormatado() {
		String num;
		String cepFormat = String.valueOf(this.cep);
		
		if (this.numero==0) {
			num="S/N";
		}else {
			num=String.valueOf(this.numero);
		}
		
		while(cepFormat.length() < 8) {
			cepFormat =cepFormat+"0";
		}
		
		cepFormat = cepFormat.substring(0, 5) + "-" + cepFormat.substring(5, cepFormat.length());
		
		String endereco = this.rua+", "+num+", "+this.complemento+", "+this.bairro+", "+this.cidade+", "+this.uf+". CEP: "+cepFormat;

		return endereco;
	}
}
