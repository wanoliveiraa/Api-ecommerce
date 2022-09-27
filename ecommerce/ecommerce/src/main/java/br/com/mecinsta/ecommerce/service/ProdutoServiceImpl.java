package br.com.mecinsta.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mecinsta.ecommerce.dao.ProdutoDAO;
import br.com.mecinsta.ecommerce.model.Produto;
@Service
public class ProdutoServiceImpl implements IProdutoService {
	
	@Autowired
	private ProdutoDAO dao;
	
	@Override
	public ArrayList<Produto> recuperarTodos() {
		
		return (ArrayList<Produto>)dao.findAll();
		//return dao.findByOrderByPreco();
		//return dao.findByOrderByPrecoDesc()
		//return dao.findByNomeContaining("Console");
	}

	@Override
	public Produto recuperarPeloCodigo(Integer codigo) {
		
		return dao.findById(codigo).orElse(null);
	}

	@Override
	public Produto cadastarNovo(Produto novo) {
		return dao.save(novo);
	}

	@Override
	public ArrayList<Produto> buscarPorPalavraChave(String palavra) {
		return dao.findByNomeContaining(palavra);
	}
	
	
	
}
