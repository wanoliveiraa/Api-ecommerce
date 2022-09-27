package br.com.mecinsta.ecommerce.service;

import java.util.ArrayList;

import br.com.mecinsta.ecommerce.model.Produto;

public interface IProdutoService   {
	
	public ArrayList<Produto> recuperarTodos();
	public Produto recuperarPeloCodigo(Integer codigo);
	public Produto cadastarNovo(Produto novo);
	public ArrayList<Produto> buscarPorPalavraChave(String palavra);
}
