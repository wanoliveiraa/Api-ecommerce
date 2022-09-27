package br.com.mecinsta.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mecinsta.ecommerce.dao.DepartamentoDAO;
import br.com.mecinsta.ecommerce.model.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService  {
	
	
	@Autowired 
	private DepartamentoDAO dao;
	
	@Override
	public Departamento criaNovo(Departamento novo) {
		if(novo.getNome()!=null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Departamento atualizarDados(Departamento dados) {
		if(dados.getCodigo()!=null && dados.getNome()!=null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<Departamento> buscarTodos() {
		ArrayList<Departamento> lista;
		
		lista=(ArrayList<Departamento>)dao.findAll();
		
		return lista;
	}

	@Override
	public Departamento buscarPeloId( Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void excluirDepartamento(Integer id) {
		dao.deleteById(id);
		
	}

	
	
}
