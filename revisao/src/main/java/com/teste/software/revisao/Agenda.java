package com.teste.software.revisao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

import com.teste.software.revisao.Sala.Equipamento;

public class Agenda {
//	private ArrayList<Sala> salas;	
	private Map<LocalDate, ArrayList<Sala>> reservas;
	
	public Agenda(Map<LocalDate, ArrayList<Sala>> reservas) {
		
		this.reservas = reservas;
	}
	
	public void listarSalas() {
		ArrayList<Sala> salas = (ArrayList<Sala>) reservas.values().toArray()[0];
		for (Sala sala : salas) {
			System.out.println(sala);
		}
	}
	
	public Sala listaSalasPorDataHorario(LocalDate date, LocalTime time) {
		
		ArrayList<Sala> reservaPorData = reservas.get(date);
		for (Sala sala : reservaPorData) {
			if (sala.isAvailable(time)) {
				return sala;				
			}
		}
		return null;
	}
	
	public void agendar(int id) {
		LocalDate today = LocalDate.now();
		//lista todas reservas pra hoje
		ArrayList<Sala> reservaPorData = reservas.get(today);
		
		for (Sala sala : reservaPorData) {
			//pega as reservas da sala requerida
			if (sala.getId() == id) {
				//varre as reservas da sala requerida
				reservaProximoHorario(sala);
				
			}
		}
	}
	
	public void agendar(int capacidade, Equipamento equip) {
		LocalDate today = LocalDate.now();
		//lista todas reservas pra hoje
		ArrayList<Sala> reservaPorData = reservas.get(today);
		
		for (Sala sala : reservaPorData) {
			//pega as reservas da sala requerida
			if (sala.getCapacidade() >= capacidade) {
				if (sala.getEquipamentos().contains(equip)) {
					reservaProximoHorario(sala);
				}
			}
		}
	
	}
	
	public void reservaProximoHorario(Sala sala) {
		Map<LocalTime, Boolean> mapa = sala.getReservas();
		
		for(Map.Entry<LocalTime, Boolean> entry : mapa.entrySet()) {
			LocalTime time = entry.getKey();
			Boolean value = entry.getValue();
		    if (sala.isAvailable(time)) {
		    	sala.reserva(time);
		    }
		}
	}
}