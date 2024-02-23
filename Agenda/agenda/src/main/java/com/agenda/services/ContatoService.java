package com.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.entidades.Contato;
import com.agenda.entidades.Endereco;
import com.agenda.repositories.ContatoRepository;
import com.agenda.repositories.EnderecoRepository;

@Service
public class ContatoService {
    @Autowired
	private ContatoRepository repository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
	
	public List<Contato> consultar(){
		return repository.findAll();
	}
	
	public Contato alterar(Contato contato) {
		/*objeto monitorado*/
		Contato ct = consultar(contato.getId());
		ct.setNome(contato.getNome());
		ct.setFone(contato.getFone());
		repository.save(ct);
		return ct;
	}

	public Contato inserir(Contato contato) {
		Endereco endereco = enderecoRepository.findById(contato.getEndereco().getId()).get();
		contato.setEndereco(endereco);
		return repository.save(contato);
	}

	public Contato consultar(Long id) {
		Optional<Contato> opt = repository.findById(id);
		Contato ct = opt.orElseThrow(()-> new RuntimeException("Contato não existe!"));
		return ct;
	}
	
	public Contato getByEmail(String email) {
		return repository.findByEmail(email);
	}
}