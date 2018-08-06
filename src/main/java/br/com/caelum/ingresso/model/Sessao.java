package br.com.caelum.ingresso.model;

import java.time.LocalTime;
import java.util.Calendar;

public class Sessao {
	private Filme filme;
	private Sala sala;
	private LocalTime horario;
	
	public Sessao(Sala sala, Filme filme, LocalTime horario){
		this.sala=sala;
		this.filme=filme;
		this.horario=horario;
		
	}
	
	public LocalTime getHorarioTermino(){
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
}
