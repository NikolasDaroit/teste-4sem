package com.teste.software.revisao;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sala {
	private int id;
	private Integer capacidade;
	private List<Equipamento> equipamentos;
	private Map<LocalTime, Boolean> reservas;
	
	public Sala(int id, Integer capacidade, List<Equipamento> equipamentos) {
		this.id = id;
		this.capacidade = capacidade;
		this.equipamentos = equipamentos;
	}

	public Sala(int id, Integer capacidade, List<Equipamento> equipamentos, List<LocalTime> listTime) {
		this.id = id;
		this.capacidade = capacidade;
		this.equipamentos = equipamentos;
		this.reservas= new HashMap<LocalTime, Boolean>();
		for (LocalTime localTime : listTime) {
			this.reservas.put(localTime, false);
		}
	}
	
	public Sala(List<LocalTime> listTime) {
		reservas= new HashMap<LocalTime, Boolean>();
		for (LocalTime localTime : listTime) {
			reservas.put(localTime, false);
		}
	}
	public enum Equipamento {
		 PROJETOR, MICROFONE, QUADROBRANCO
	}
	

	public boolean isAvailable(LocalTime time) {
		return !reservas.get(time);
	}


	public int getId() {
		return id;
	}


	public Integer getCapacidade() {
		return capacidade;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}


	public Map<LocalTime, Boolean> getReservas() {
		return reservas;
	}
	public void reserva(LocalTime time) {
		this.reservas.put(time, true);
		
	}

}
