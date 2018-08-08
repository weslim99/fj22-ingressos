package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.ManyToAny;

import br.com.caelum.ingresso.model.descontos.Desconto;
@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Sessao sessao;	
	private BigDecimal preco;
	@ManyToOne
	private Lugar lugar;
	@Enumerated(EnumType.STRING)	
	private TipoDeIngresso tipoDeIngresso;
	
	/**
	 * 
	 * @deprecated hibernate only
	 */
	public Ingresso() {
		
	}
	
	public Ingresso (Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
		this.sessao=sessao;
		this.tipoDeIngresso = tipoDeIngresso;
		this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		
		this.lugar = lugar;
	}
	
	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	
}
