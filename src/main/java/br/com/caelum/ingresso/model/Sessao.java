package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Sessao {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Filme filme;
	@ManyToOne
	private Sala sala;
	private LocalTime horario;
	private BigDecimal preco;
	// precisa criar sempre um construtor sem argumentos //
	/**
	 * @deprecated hibernate only
	 */
	public Sessao (){
		
	}
	
	public Sessao(LocalTime horario, Filme filme,Sala sala ){
		this.sala=sala;
		this.filme=filme;
		this.horario=horario;
		
		this.preco = sala.getPreco().add(filme.getPreco());
		
	}
	public BigDecimal getPreco(){
    	return preco.setScale(2, RoundingMode.HALF_UP);
    }
    
    public void setPreco(BigDecimal preco){
    	this.preco= preco;
    }
	public LocalTime getHorarioTermino(){
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public Map<String, List<Lugar>> getMapaDeLugares(){
		return sala.getMapaDeLugares();
	}
}
