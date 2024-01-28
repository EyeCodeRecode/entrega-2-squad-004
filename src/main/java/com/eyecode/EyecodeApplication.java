package com.eyecode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;

import com.eyecode.entities.Contact;
import com.eyecode.entities.Role;
import com.eyecode.entities.Usuario;
import com.eyecode.repositories.ContactRepository;
import com.eyecode.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@SpringBootApplication
public class EyecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyecodeApplication.class, args);
	}

	
	@Autowired
	UserRepository userRepository;
	
	
	@PostConstruct
	public void importSql() {
		
		
		/*
		
		Usuario user = new Usuario();
		
		user.setEmail("Cristianascimento@gmail.com");
		user.setNome("Cristian");
		user.setSenha("password");
		user.setDeficiencia("Não possuí");
		
		ArrayList<Role> roles = new ArrayList<>();
		
		roles.add(new Role("ROLE_ADMIM"));
		
		user.setRoles(roles);
		
		userRepository.save(user);
		*/
		
	}
}
