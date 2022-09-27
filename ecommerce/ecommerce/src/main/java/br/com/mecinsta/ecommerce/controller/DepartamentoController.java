package br.com.mecinsta.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mecinsta.ecommerce.model.Departamento;
import br.com.mecinsta.ecommerce.service.IDepartamentoService;


@RestController
public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService service;
	
	
	@GetMapping("/departamentos")
	public ArrayList<Departamento> recuperarTodos(){
		return service.buscarTodos();
		
	}
	
	@PostMapping("/departamentos")
	public ResponseEntity<Departamento> inserirNovo(@RequestBody Departamento novo) {
		Departamento res=service.criaNovo(novo);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	
	}
	
	
	
	@PutMapping("/departamentos")
	public ResponseEntity<Departamento> atualizarDados(@RequestBody Departamento dados){
		Departamento res=service.atualizarDados(dados);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	@DeleteMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> excluirDepartamento(@PathVariable Integer id) {
	
		service.excluirDepartamento(id);
		return ResponseEntity.ok(null);
	}
	@GetMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> buscarId(@PathVariable Integer id){
		Departamento res=service.buscarPeloId(id);
		if(res!=null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
