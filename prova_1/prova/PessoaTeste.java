package com.teste.software.prova;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.teste.software.revisao.Sala;

public class PessoaTeste {
	Pessoa pessoa;
	
	@Before
	public void setup() {
		Endereco endereco = mock(Endereco.class);
		when(endereco.getEnderecoFormatado()).thenReturn(new String("Rua dos bobos, 12, nao, louco, teste, ZZ. CEP: 55444-200"));
		pessoa = new Pessoa("Nome Pessoa", endereco, Long.parseLong("11122233"));
		
	}

	@Test
	public void testNomeMenos3Mais40() {
		assertThatThrownBy(() -> { pessoa.setNome("as"); })
		.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> { pessoa.setNome("a1234567890123456789012345678901234567890"); })
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test 
	public void testCPF() {
		assertThatThrownBy(() -> { pessoa.setCpf(Long.parseLong("-10")); })
		.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> { pessoa.setCpf(Long.parseLong("554442245225")); })
		.isInstanceOf(IllegalArgumentException.class);
		
	}
	@Test 
	public void testGetInfo() {
		assertThat(pessoa.getInformacoes()).contains("00011122233");
		assertThat(pessoa.getInformacoes()).containsIgnoringCase("Nome: Nome Pessoa\n" + 
				"CPF: 00011122233\n" + 
				"Endereco: Rua dos bobos, 12, nao, louco, teste, ZZ. CEP: 55444-200");
	}
}
