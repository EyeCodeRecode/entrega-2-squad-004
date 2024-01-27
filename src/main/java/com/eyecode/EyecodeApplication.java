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
import com.eyecode.entities.Course;
import com.eyecode.entities.Role;
import com.eyecode.entities.Usuario;
import com.eyecode.repositories.ContactRepository;
import com.eyecode.repositories.CourseRepository;
import com.eyecode.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@SpringBootApplication( )
public class EyecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyecodeApplication.class, args);
	}

	@Autowired
	CourseRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostConstruct
	public void importSql() {
		
		
		Usuario user = new Usuario();
		
		user.setEmail("Cristianascimento@gmail.com");
		user.setNome("Fulano");
		//A senha é "password"
		user.setPassword("$2y$10$qnQvSDDAws3phToeXfLDS.fgIghxBfvnb9QcDrSDLh6blQ2zKe6K2");
		user.setDeficiencia("Não possuí");
		
		ArrayList<Role> roles = new ArrayList<>();
		
		roles.add(new Role("ROLE_ADMIN"));
		roles.add(new Role("ROLE_USER"));
		
		user.setRoles(roles);
		
		if( userRepository.findByName(user.getNome()) == null ){
			userRepository.save(user);

		}
		
		
	
	}
	
}
