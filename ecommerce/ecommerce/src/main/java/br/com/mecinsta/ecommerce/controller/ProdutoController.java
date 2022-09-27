package br.com.mecinsta.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mecinsta.ecommerce.model.Produto;
import br.com.mecinsta.ecommerce.service.IProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService service;
	
	//recuperar geral
	
	@GetMapping("/produtos")
	public ArrayList<Produto> listarProduto(){
		return service.recuperarTodos();
	}
	//recuperar pelo id 
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> recuperarId(@PathVariable Integer id) {
		Produto res=service.recuperarPeloCodigo(id);
		if(res !=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).build();
	}
	//cadastrar
	@PutMapping("/produtos")
	public ResponseEntity<Produto> inserirNovo(@RequestBody Produto novo){
		Produto res=service.cadastarNovo(novo);
		if(res !=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	@GetMapping("/produtos/busca")
	public ArrayList<Produto> recuperarPorPalavra(@RequestParam (name="palavra") String palavra){
		return service.buscarPorPalavraChave(palavra);
	}
}
