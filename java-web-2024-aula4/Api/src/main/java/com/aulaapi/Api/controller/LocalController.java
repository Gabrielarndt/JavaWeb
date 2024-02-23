package com.aulaapi.Api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaapi.Api.entidades.Contato;
import com.aulaapi.Api.entidades.Local;
import com.aulaapi.Api.repositorios.LocalRepositroy;

@RestController
@RequestMapping("/locais")
public class LocalController {
	private static List<Local> locais = new ArrayList<Local>();
   
	@Autowired //injeta o objeto nesta classe
	LocalRepositroy repositroy;
	
	@GetMapping
	public ResponseEntity<?> consultar(){
		//return ResponseEntity.status(HttpStatus.OK).body(locais);
		return ResponseEntity.status(HttpStatus.OK).body(repositroy.findAll());
	}
	
	@GetMapping("/{idLocal}")
	public ResponseEntity<?> consultarUm(@PathVariable("idLocal") Long id){
		Local local = existeLocal(id);
		if(local != null)
		   return ResponseEntity.status(HttpStatus.OK).body(local);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("message: Local não encontrado");
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Local local){
		/*local.setId(locais.size()+1l);
		locais.add(local);*/
		repositroy.save(local);
		return ResponseEntity.status(HttpStatus.CREATED).body(local);
	}
	
	private Local existeLocal(Long idLocal) {
		Local local = null;
		for(Local lc : locais) {
			if(lc.getId() == idLocal) {
				local = lc;
				break;
			}
		}
		return local;
	}
}
