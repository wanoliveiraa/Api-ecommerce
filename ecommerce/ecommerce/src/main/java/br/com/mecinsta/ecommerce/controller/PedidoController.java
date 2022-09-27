package br.com.mecinsta.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mecinsta.ecommerce.dto.FaturamentoMensal;
import br.com.mecinsta.ecommerce.model.Pedido;
import br.com.mecinsta.ecommerce.service.IPedidoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	@GetMapping("/pedidos/{numero}")
	public ResponseEntity<Pedido> recuperarPeloNumero(@PathVariable Integer numero){
		Pedido res=service.recuperarPeloNumero(numero);
		
		if(res !=  null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/pedidos")
	public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido novo){
		Pedido res=service.inserir(novo);
		if(res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).build();
	}

	@GetMapping("/faturamento/{ano}")
	public ArrayList<FaturamentoMensal> recuperarFaturamento(@PathVariable Integer ano) {
		return service.recuperarFaturamento(ano);
	}
	
}
