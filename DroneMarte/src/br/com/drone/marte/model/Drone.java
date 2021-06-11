package br.com.drone.marte.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drone {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private String pressao;
	private String velocidade;
	private String duracao;
	private String altitude;
	private String rota;
	
	
	public Drone() {
	}
	
	public Drone(String pressao, String velocidade, String duracao, String altitude, String rota) {
		super();
		this.pressao = pressao;
		this.velocidade = velocidade;
		this.duracao = duracao;
		this.altitude = altitude;
		this.rota = rota;
	}
	
	public String getPressao() {
		return pressao;
	}
	public void setPressao(String pressao) {
		this.pressao = pressao;
	}
	
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}
	
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	public String getRota() {
		return rota;
	}
	public void setRota(String rota) {
		this.rota = rota;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
