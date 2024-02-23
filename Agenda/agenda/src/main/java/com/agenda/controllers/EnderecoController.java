package com.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.agenda.entidades.Endereco;
import com.agenda.services.EnderecoService;

public class EnderecoController {
	@Autowired
	EnderecoService service;
	
	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.OK).body(service.inserir(endereco));
	}
}
