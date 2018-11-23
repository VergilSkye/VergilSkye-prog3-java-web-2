package br.com.prog3.aula14.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "veiculo")
@Proxy(lazy = false)
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="placa")
	private String placa;
	public List<Multa> getMultas() {
		return multas;
	}
	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	@Column(name="anoFabricacao")
	private Integer anoFabricacao;
	@Column(name="anoModelo")
	private Integer	anoModelo;
	@Column(name="cor")
	private String	cor;
	@OneToMany	(mappedBy="veiculo",targetEntity=Multa.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Multa> multas;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}