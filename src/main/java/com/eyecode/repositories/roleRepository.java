package com.eyecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eyecode.entities.Role;

public interface roleRepository extends JpaRepository<Role, Long>{

	Role findByAuthority(String authority);
	
}
