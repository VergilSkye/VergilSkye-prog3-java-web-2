package br.com.prog3.aula14.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.prog3.aula14.persistence.MultaDaoImp;
import br.com.prog3.aula14.persistence.VeiculoDaoImp;
import br.com.prog3.aula14.model.Multa;
import br.com.prog3.aula14.model.Veiculo;

@ManagedBean(name = "multaBean")
@RequestScoped
public class MultaController {

	private Integer codigo;
	private String descricao;
	private String artigoviolado;
	private String placa;
	private String search;


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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Multa getMulta() {
		return multa;
	}
	public void setMulta(Multa multa) {
		this.multa = multa;
	}
	public List<Multa> getListMulta() {
		return listMulta;
	}
	public void setListMulta(List<Multa> listMulta) {
		this.listMulta = listMulta;
	}
	private Veiculo veiculo;

	private Multa multa;
	private List<Multa> listMulta = new ArrayList<Multa>();
	private List<Multa> listMultados = new ArrayList<Multa>();
	
	public void loadMultaDetail() throws SQLException {
		Integer emp = codigo;

		MultaDaoImp ad = new MultaDaoImp();
		Multa al = ad.buscarPeloCodigo(emp);
		if (al != null) {
			this.artigoviolado=al.getArtigoviolado();
			this.descricao=al.getDescricao();		
			Veiculo ve = al.getVeiculo();
			this.placa=ve.getPlaca();
			System.out.println(ve.getPlaca());
		}

	}
	
	public void addMulta() {
		Multa mul = new Multa();
		this.placa=placa;
		
		mul.setCodigo(codigo);		
		mul.setDescricao(descricao);
		mul.setArtigoviolado(artigoviolado);
		
		veiculo=findVeiculo();			
		
		
		if(!(veiculo==null)) {
			mul.setVeiculo(veiculo);

		MultaDaoImp ad = new MultaDaoImp();
		ad.incluir(mul);
		}

	}

	public void editMulta() {
		Multa mul = new Multa();
		mul.setCodigo(codigo);
		mul.setDescricao(descricao);
		mul.setArtigoviolado(artigoviolado);
		
		veiculo=findVeiculo();
		mul.setVeiculo(veiculo);
		if(!(veiculo==null)) {
		MultaDaoImp ad = new MultaDaoImp();
		ad.alterar(mul);
		}

	}

	public void deleteMulta() {
		System.out.println("OCODIGO"+codigo);
		Multa mul = buscarPeloCodigo(codigo);

		MultaDaoImp ad = new MultaDaoImp();
		ad.excluir(mul);
		
	}
	public Veiculo findVeiculo() {
		VeiculoDaoImp ad = new VeiculoDaoImp();	
		return ad.buscarPelaPlaca(placa);
	}

	public List<Multa> getMultas() {
		MultaDaoImp ad = new MultaDaoImp();
		return ad.listarTodos();
	}

	public Multa findMulta() {
		MultaDaoImp ad = new MultaDaoImp();
		return ad.buscarPeloCodigo(codigo);
	}

	@PostConstruct
	public void init() {
		MultaDaoImp ad = new MultaDaoImp();
		listMulta = ad.listarTodos();
	}
	

	public void incluir(Multa multa) {
		MultaDaoImp md = new MultaDaoImp();
		md.incluir(multa);
	}

	public void alterar(Multa multa) {
		MultaDaoImp md = new MultaDaoImp();
		md.alterar(multa);
	}

	public void excluir(Multa multa) {
		MultaDaoImp md = new MultaDaoImp();
		md.excluir(multa);
	}

	public List<Multa> listarTodos() {
		MultaDaoImp md = new MultaDaoImp();
		return md.listarTodos();
	}

	public Multa buscarPeloCodigo(int codigo) {
		MultaDaoImp md = new MultaDaoImp();
		return md.buscarPeloCodigo(codigo);
	}

	public List<Multa> buscarPeloVeiculo(Veiculo veiculo) {
		MultaDaoImp md = new MultaDaoImp();
		return md.buscarPeloVeiculo(veiculo);
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public List<Multa> getListMultados() {
		return listMultados;
	}
	public void setListMultados(List<Multa> listMultados) {
		this.listMultados = listMultados;
	}
	

}
