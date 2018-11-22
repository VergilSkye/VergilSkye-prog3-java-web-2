package br.com.prog3.aula14.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.prog3.aula14.persistence.VeiculoDaoImp;
import br.com.prog3.aula14.model.Veiculo;


@ManagedBean(name="veiculoBean")
@RequestScoped
public class VeiculoController {
	
	private String placa;
	private Integer anoFabricacao;
	private Integer	anoModelo;
	private String	cor;
	private Veiculo veiculo;
	private List<Veiculo> listVeiculo = new ArrayList<Veiculo>();
	
	public void loadVeiculoDetail() throws SQLException {
		String emp = placa;

		VeiculoDaoImp ad = new VeiculoDaoImp();	
		Veiculo al = ad.buscarPelaPlaca(emp);
		if (al != null) {
			this.anoFabricacao = al.getAnoFabricacao();
			this.anoModelo = al.getAnoModelo();
			this.cor = al.getCor();
		}

	}
	
	public void addVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(placa);
		veiculo.setAnoFabricacao(anoFabricacao);
		veiculo.setAnoModelo(anoModelo);
		veiculo.setCor(cor);
		VeiculoDaoImp ad = new VeiculoDaoImp();		
		ad.incluir(veiculo);	
		
	}
	
	public void editVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(placa);
		veiculo.setAnoFabricacao(anoFabricacao);
		veiculo.setAnoModelo(anoModelo);
		veiculo.setCor(cor);
		VeiculoDaoImp ad = new VeiculoDaoImp();		
		ad.alterar(veiculo);	
		
	}
	public void deleteVeiculo() {
		Veiculo veiculo = new Veiculo();	
		veiculo.setPlaca(placa);
		System.out.println("APLACA:"+placa);
		veiculo.setAnoFabricacao(anoFabricacao);
		veiculo.setAnoModelo(anoModelo);
		veiculo.setCor(cor);
		VeiculoDaoImp ad = new VeiculoDaoImp();		
		ad.excluir(veiculo);	
		
	}
	public List<Veiculo> getVeiculos() {
		VeiculoDaoImp ad = new VeiculoDaoImp();
		return ad.listarTodos();		
	}
	public Veiculo findVeiculo() {
		VeiculoDaoImp ad = new VeiculoDaoImp();	
		return ad.buscarPelaPlaca(placa);
	}
	
	@PostConstruct
	public void init() {
		VeiculoDaoImp ad = new VeiculoDaoImp();	
		listVeiculo= ad.listarTodos();	}

	
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


	public Veiculo getAluno() {
		return veiculo;
	}

	public void setVeiculo(Veiculo vei) {
		this.veiculo = vei;
	}

	
	public List<Veiculo> getListVeiculo() {
		return listVeiculo;
	}

	public void setListVeiculo(List<Veiculo> listVeiculo) {
		this.listVeiculo = listVeiculo;
	}
}
