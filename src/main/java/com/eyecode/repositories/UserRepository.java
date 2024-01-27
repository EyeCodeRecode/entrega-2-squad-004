package com.eyecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyecode.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	Usuario findByName(String nome);
	
}
