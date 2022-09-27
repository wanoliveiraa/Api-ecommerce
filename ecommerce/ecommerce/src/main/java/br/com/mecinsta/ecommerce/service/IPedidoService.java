package br.com.mecinsta.ecommerce.service;



import java.util.ArrayList;

import br.com.mecinsta.ecommerce.dto.FaturamentoMensal;
import br.com.mecinsta.ecommerce.model.Pedido;

public interface IPedidoService {
	
	
	
	public Pedido recuperarPeloNumero(Integer numero);
	public Pedido inserir(Pedido novo);
	public ArrayList<FaturamentoMensal> recuperarFaturamento(Integer ano);
	
}
