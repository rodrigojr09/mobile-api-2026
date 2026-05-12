package br.fatec.aulaapi.dto;

import java.util.List;

public class Pedido {
	
	private Integer codigo;
	
	private String tipo;
	
	private Cliente cliente;
	
	private List<Produto> itens;
	
	private Double total;
	
	
	
}