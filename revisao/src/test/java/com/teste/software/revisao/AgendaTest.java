package com.teste.software.revisao;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
public class AgendaTest {
	Agenda agenda;
	@Before 
	public void setup() {
		Map<LocalDate, ArrayList<Sala>> reservas = new HashMap<>();
		ArrayList<Sala> salas = new ArrayList<>();
		
		Sala sala = mock(Sala.class);
		when(sala.getId()).thenReturn(new Integer(6));
		when(sala.isAvailable(LocalTime.of(8, 0))).thenReturn(true);
		when(sala.isAvailable(LocalTime.of(9, 0))).thenReturn(false);
		
		
		salas.add(sala);
		
		reservas.put(LocalDate.of(2000, 01, 12), salas);
		agenda = new Agenda(reservas);
	}
	@Test
	public void testHasSalaAvailable() {
		assertThat(agenda.listaSalasPorDataHorario(LocalDate.of(2000, 01, 12),LocalTime.of(8, 0))).isNotNull();
	}
	@Test
	public void testHasSalaUnavailable() {
		assertThat(agenda.listaSalasPorDataHorario(LocalDate.of(2000, 01, 12),LocalTime.of(9, 0))).isNull();
	}
}
