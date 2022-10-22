package entities;

import java.util.Date;

public class ContratoHora {
	private Date date;
	private Double porHora;
	private Integer hora;
	
	public ContratoHora() {
		
	}
	
	public ContratoHora(Date date, Double porHora, Integer hora) {
		this.date = date;
		this.porHora = porHora;
		this.hora = hora;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPorHora() {
		return porHora;
	}
	public void setPorHora(Double porHora) {
		this.porHora = porHora;
	}
	public Integer getHora() {
		return hora;
	}
	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
	public double valorTotal() {
		return porHora * hora;
	}
	
	
	
}
