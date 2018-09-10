package com.teste.software.revisao;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SalaTest {
	private List<LocalTime> horarios;
	
	@Before
	public void setup() {
		horarios = new ArrayList<>();
		LocalTime t = LocalTime.of(8, 0); horarios.add(t);
		t = LocalTime.of(9, 0); horarios.add(t);
		t = LocalTime.of(10, 0); horarios.add(t);
		t = LocalTime.of(11, 0); horarios.add(t);
		t = LocalTime.of(12, 0); horarios.add(t);

	}
	@Test
	public void testSalaAvailable() {
		Sala sala = new Sala(1, 10, null, horarios);
		assertThat(sala.isAvailable(LocalTime.of(8, 0))).isTrue();
	}
	@Test
	public void testSalaReserva() {
		Sala sala = new Sala(1, 10, null, horarios);
		sala.reserva(LocalTime.of(8, 0));
		assertThat(sala.isAvailable(LocalTime.of(8, 0))).isFalse();
	}

}
