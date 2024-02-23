package com.agenda.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.entidades.Endereco;
		
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
