package com.teste.software.prova;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class EnderecoTeste {
	Endereco end;
	
	@Before
	public void setup() {
		end = new Endereco("Rua dos bobos", "louco", "nao", "teste", "ZZ", 12 , Long.parseLong("554442"));
	}
	@Test
	public void testRuaMenos3Mais30() {
		end.setRua("ab");
		assertThat(end.getEnderecoFormatado().substring(0, 4)).containsIgnoringCase("N.D.");
	
		end.setRua("123456789012334567890123456789012345678890");
		assertThat(end.getEnderecoFormatado().substring(0, 4)).containsIgnoringCase("N.D.");
	}
	
	@Test
	public void testBairroMenos3Mais20() {
		end.setBairro("ab");
		assertThat(end.getEnderecoFormatado()).containsIgnoringCase("N.D.");
	
		end.setBairro("123456789012345678901234567890");
		assertThat(end.getEnderecoFormatado()).containsIgnoringCase("N.D.");
	}
	
	@Test
	public void testNumero() {
		
		assertThatThrownBy(() -> { end.setNumero(-123); })
		.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> { end.setNumero(0); })
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void testCep() {
		
		assertThatThrownBy(() -> { end.setCep(-123); })
		.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> { end.setCep(0); })
		.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> { end.setCep(1234567890); })
		.isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	public void testUF() {
		
		assertThatThrownBy(() -> { end.setUF("asd"); })
		.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> { end.setUF("a"); })
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void testFormatado() {
		assertThat(end.getEnderecoFormatado()).containsIgnoringCase("Rua dos bobos, 12, nao, louco, teste, ZZ. CEP: 55444-200");

		end.setCep(55);
		assertThat(end.getEnderecoFormatado()).containsIgnoringCase("Rua dos bobos, 12, nao, louco, teste, ZZ. CEP: 55000-000");

	}
}
