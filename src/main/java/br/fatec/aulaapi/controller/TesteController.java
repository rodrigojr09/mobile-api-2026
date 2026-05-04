package br.fatec.aulaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	
	@GetMapping(path = "/ping")
	public String ping() {
		
		return "ok fabio";
	}
}
