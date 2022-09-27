package br.com.mecinsta.ecommerce.service;

import java.util.ArrayList;

import br.com.mecinsta.ecommerce.model.Departamento;

public interface IDepartamentoService {
	public Departamento criaNovo(Departamento novo);
	public Departamento atualizarDados(Departamento dados);
	public ArrayList<Departamento> buscarTodos();
	public  Departamento buscarPeloId(Integer id);
	public void excluirDepartamento(Integer id);
}
