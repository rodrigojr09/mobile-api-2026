package br.fatec.aulaapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aulaapi.dto.Pedido;

@RestController
public class PedidoController {
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	@GetMapping(path="/pedidos/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Pedido pedido = null;
		for(Pedido p : pedidos) {
			if(p.)
		}
	}
	
	@GetMapping(path="/pedidos")
	public Pedido buscarPedidos() {
		return pedidos;
	}
	
	
}
