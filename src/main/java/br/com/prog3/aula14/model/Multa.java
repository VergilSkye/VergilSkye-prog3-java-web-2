package br.com.prog3.aula14.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "multa")
@Proxy(lazy = false)
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codigo")
	private Integer codigo;
	@Column(name="descricao")
	private String descricao;
	@Column(name="artigoviolado")
	private String artigoviolado;
	
	@ManyToOne @JoinColumn(name="placa")
	private Veiculo veiculo;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getArtigoviolado() {
		return artigoviolado;
	}
	public void setArtigoviolado(String artigoviolado) {
		this.artigoviolado = artigoviolado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}