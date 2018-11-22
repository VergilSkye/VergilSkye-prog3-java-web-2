package br.com.prog3.aula14.controller;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.prog3.aula14.model.Multa;
import br.com.prog3.aula14.model.Veiculo;
import br.com.prog3.aula14.util.HibernateUtil;
import br.com.prog3.aula14.controller.VeiculoController;

@SuppressWarnings("unused")
public class Teste {
	public static void main(String[] args) {

		HibernateUtil.getSessionFactory();
//		Veiculo v = new Veiculo();
//		VeiculoController vc = new VeiculoController();
//		v.setPlaca("AAAA4578");
//		v.setAnoFabricacao(2000);
//		v.setAnoModelo(2002);
//		v.setCor("Preto");
//		vc.alterar(v);
//		VeiculoController vc = new VeiculoController();
//		List<Veiculo> lista = vc.listarTodos();
//		if (lista != null) {
//			for (Veiculo ve : lista) {
//				System.out.println("Placa: " + ve.getPlaca());
//				System.out.println("Cor: " + ve.getCor());
//			}
//		}
//		VeiculoController vc = new VeiculoController();
//		Veiculo ve = vc.buscarPelaPlaca("JIB4590");
//		if(ve != null){
//		System.out.println("Placa: "+ve.getPlaca());
//		System.out.println("Cor: "+ve.getCor());
//		System.out.println("Ano de fabricação: "+ve.getAnoFabricacao());
//		}
//		Multa m = new Multa();
//		Veiculo v = new Veiculo();
//		MultaController mc = new MultaController();
//		v.setPlaca("JIB4590");
//		m.setCodigo(1);
//		m.setDescricao("Ultrapassou com sinal vermelho");
//		m.setArtigoviolado("Art. 3");
//		m.setVeiculo(v);
//		mc.incluir(m);
//		m.setCodigo(2);
//		m.setDescricao("Estacionamento proibido");
//		m.setArtigoviolado("Art. 5");
//		m.setVeiculo(v);
//		mc.incluir(m);
//		v.setPlaca("AAAA4578");
//		m.setCodigo(3);
//		m.setDescricao("Parou na faixa de pedestre");
//		m.setArtigoviolado("Art. 10");
//		m.setVeiculo(v);
//		mc.incluir(m);
//		m.setCodigo(4);
//		m.setDescricao("Estacionamento proibido");
//		m.setArtigoviolado("Art. 5");
//		m.setVeiculo(v);
//		mc.incluir(m);
//		m.setCodigo(5);
//		m.setDescricao("Velocidade acima do permitido");
//		m.setArtigoviolado("Art. 8");
//		m.setVeiculo(v);
//		mc.incluir(m);
//		
//		Multa m = new Multa();
//		Veiculo v = new Veiculo();
//		MultaController mc = new MultaController();
//		v.setPlaca("JIB4590");
//		m.setCodigo(1);
//		m.setDescricao("Ultrapassou com sinal vermelho");
//		m.setArtigoviolado("Art. 35");
//		m.setVeiculo(v);
//		mc.alterar(m);
//		MultaController mc = new MultaController();
//		List<Multa> lista = mc.listarTodos();
//		if (lista != null) {
//			for (Multa mu : lista) {
//				System.out.println("Placa: " + mu.getVeiculo().getPlaca());
//				System.out.println("Descrição: " + mu.getDescricao());
//			}
//		}
//		MultaController mc = new MultaController();
//		Multa mu = mc.buscarPeloCodigo(3);
//		if (mu != null) {
//			System.out.println("Placa: " + mu.getVeiculo().getPlaca());
//			System.out.println("Descrição: " + mu.getDescricao());
//		}
		Veiculo v = new Veiculo();
		v.setPlaca("JIB4590");
		MultaController mc = new MultaController();
		List<Multa> lista = mc.buscarPeloVeiculo(v);
		if (lista != null) {
			for (Multa mu : lista) {
				System.out.println("Placa: " + mu.getVeiculo().getPlaca());
				System.out.println("Descrição: " + mu.getDescricao());
			}
		}
	}
}
