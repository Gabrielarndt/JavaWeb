package com.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.entidades.Endereco;
import com.agenda.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository repository;
	
	public List<Endereco> consultar() {
		return repository.findAll();
	}

	public Endereco inserir(Endereco endereco) {
		return repository.save(endereco);
	}
}
