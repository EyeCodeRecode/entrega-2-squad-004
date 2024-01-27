package com.eyecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyecode.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String nome);
	
}
