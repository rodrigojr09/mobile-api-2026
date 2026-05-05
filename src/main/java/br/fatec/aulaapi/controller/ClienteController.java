package br.fatec.aulaapi.controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aulaapi.dto.Cliente;

@RestController
public class ClienteController {
	
	private static final List<Cliente> clientes = new ArrayList<>();
	
	@GetMapping(path = "/clientes/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id){
		
		Cliente cliente = null;
		for(Cliente c : clientes) {
			if(c.getCodigo() == id){
				cliente = c;
			}
		}
		
		if(cliente == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		}
		
	}
	
	@PostMapping(path = "/clientes")
	public ResponseEntity<?> postCliente(@RequestBody Cliente cliente){
		// Verifica email
		for(Cliente c : clientes) {
			if(c.getEmail() == cliente.getEmail()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			}
		}
		
		// Salva na lista
		cliente.setCodigo(clientes.size() + 1);
		clientes.add(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@GetMapping(path = "/clientes")
	public List<Cliente> getClientes(){
		return clientes;
	}
}
