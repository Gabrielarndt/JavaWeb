package com.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.entidades.Contato;
import com.agenda.repositories.ContatoRepository;
import com.agenda.services.ContatoService;


@RestController
@RequestMapping("/contatos")
public class contatoController {
	private ContatoService service;
	
	public contatoController(ContatoService service) {
		this.service = service;
	}
	@Autowired
	private ContatoRepository repository;
	
	@GetMapping
	public ResponseEntity<?> consultar(){
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultar(@PathVariable("id") Long id){
		try {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(id));
		} catch (RuntimeException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable("id") Long id, @RequestBody Contato contato){
		try {
			if(contato.getId() == null) {
				contato.setId(id);
			}
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(contato));
		
		} catch (RuntimeException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Contato contato){
        Contato ct = service.getByEmail(contato.getEmail());		
		if(ct != null) {
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contato já cadastrado com esse email");
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.inserir(contato));
	}
}
