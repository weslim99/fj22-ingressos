package br.com.caelum.ingresso.model;

import java.time.YearMonth;

public class Cartao {
	private Integer nomero;
	private String ccv;
	private YearMonth vencimento;
	
	public Integer getNomero() {
		return nomero;
	}
	public void setNomero(Integer nomero) {
		this.nomero = nomero;
	}
	public String getCcv() {
		return ccv;
	}
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	public YearMonth getVencimento() {
		return vencimento;
	}
	public void setVencimento(YearMonth validade) {
		this.vencimento = validade;
	}
	public boolean isValido(){
		return vencimento.isAfter(YearMonth.now());
	}
	
}
