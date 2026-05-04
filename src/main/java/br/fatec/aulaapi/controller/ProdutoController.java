package br.fatec.aulaapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aulaapi.dto.Produto;

@RestController
public class ProdutoController {
	
	private static final List<Produto> listaProdutos = new ArrayList<Produto>();

	@PostMapping(path="/produtos")
	public ResponseEntity<?> postProduto(@RequestBody Produto novoProduto) {
		
		if(novoProduto.getDescricao() == null ||
				novoProduto.getDescricao().isEmpty() ||
				novoProduto.getDescricao().length() <= 3) {
			
			return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body("Descrição inválida");
		}
		
		//gerar o codigo produto
		int codigo = (int) (Math.random() * 1000);
		novoProduto.setCodigo(codigo);
		
		//armazenar o produto na lista em memoria
		listaProdutos.add(novoProduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}
	
	
	@GetMapping(path = "/produtos")
	public List<Produto> getProdutos() {
		
		return listaProdutos;
	}
}
