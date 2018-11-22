package br.com.prog3.aula14.persistence;
import java.util.List;

import br.com.prog3.aula14.model.Veiculo;

public interface VeiculoDao {
	public void incluir(Veiculo veiculo);
	public void alterar(Veiculo veiculo);
	public void excluir(Veiculo veiculo);
	public List<Veiculo> listarTodos();
	public Veiculo buscarPelaPlaca(String placa);
}
