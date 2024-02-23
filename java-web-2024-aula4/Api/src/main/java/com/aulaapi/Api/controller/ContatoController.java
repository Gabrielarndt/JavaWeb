package com.aulaapi.Api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aulaapi.Api.entidades.Contato;

@RestController
public class ContatoController {

	private static List<Contato> contatos = new ArrayList<>();
	
	/*@GetMapping("/contatos")
	public String ola() {
		return "hello world";
	}
	
	@GetMapping("/pessoas")
	public String tchau() {
		return "arriverdi";
	}*/
	
	@GetMapping("/contatos/{idcontato}")
	public  ResponseEntity<?> consultarUm(@PathVariable("idcontato")
	Long idcontato){
		Contato contato = existeContato(idcontato);
		if (contato != null) {
		   return ResponseEntity.status(HttpStatus.OK).body(contato);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("message: contato não encontrado");
	}
	
	@GetMapping("/contatos")
	public  ResponseEntity<?> consultarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(contatos);
	}
	
	@PostMapping("/contatos")
	public ResponseEntity<?> salvar(@RequestBody Contato contato) {
		contato.setId(contatos.size()+1l);
		contatos.add(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(contato);
	}
	
	@PutMapping("/contatos/{idContato}")
	public ResponseEntity<?> alterar(@PathVariable("idContato")	Long idContato, @RequestBody Contato contato){
    	Contato con = existeContato(idContato);
		if( con != null) {
			con.setNome(contato.getNome());
			con.setEmail(contato.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body(con);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("message: contato não encontrado");
	}
	
	@DeleteMapping("/contatos/{idcontato}")
	public  ResponseEntity<?> excluir(@PathVariable("idcontato")
	Long idcontato){
		Contato contato = existeContato(idcontato);
		if (contato != null) {
		   contatos.remove(contato);	
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("message: contato não encontrado");
	}

	
	private Contato existeContato(Long idContato) {
		Contato con = null;
		for(Contato ct : contatos) {
			if(ct.getId() == idContato) {
				con = ct;
				break;
			}
		}
		return con;
	}
}

/* Verbos HTTP
 * Get  /contatos
 * GET /contatos/1
 * Post /contatos
 * Put  /contatos/1
 * Delete /contatos/1
 * */
 