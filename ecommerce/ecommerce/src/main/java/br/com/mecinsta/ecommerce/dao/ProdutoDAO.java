package br.com.mecinsta.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.mecinsta.ecommerce.model.Produto;

import java.util.ArrayList;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
	//query costumizada

	public ArrayList<Produto> findByOrderByPreco();
	public ArrayList<Produto> findByOrderByPrecoDesc();
	public ArrayList<Produto> findByNomeContaining(String palavraChave);
}
