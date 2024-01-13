package com.eyecode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eyecode.entities.Contact;
import com.eyecode.entities.Course;
import com.eyecode.repositories.ContactRepository;
import com.eyecode.repositories.CourseRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EyecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyecodeApplication.class, args);
	}

	@Autowired
	CourseRepository repository;

	
	@PostConstruct
	public void importSql() {
		
		repository.save(new Course(
					"HTML",
					"",
					"ESTRUTURA"
				));
		repository.save(new Course(
					"CSS",
					"É uma linguagem de estilo utilizada para definir a apresentação "
					+ "e o layout das páginas web. Permite estilizar elementos HTML, "
					+ "controlando cores, fontes, margens, posicionamento, entre outros.",
					"ESTILO"
			));
		repository.save(new Course(
					"JAVASCRIPT",
					"É uma linguagem de programação de alto nível, amplamente utilizada "
					+ "no desenvolvimento web para criar interatividade e dinamismo nas páginas. "
					+ "Executada no navegador do usuário, possibilita manipular elementos da página e "
					+ "responder a eventos.",
					"INTERATIVIDADE"
			));		
		repository.save(new Course(
					"JAVA",
					"É uma linguagem de programação versátil e robusta, frequentemente utilizada no "
					+ "desenvolvimento de aplicações corporativas, sistemas web e móveis. Conhecida por "
					+ "ser orientada a objetos e pela portabilidade, pode ser executada em diferentes plataformas.",
					"VERSATILIDADE"
			));		
		repository.save(new Course(
					"Banco de dados",
					"Refere-se a sistemas de gerenciamento de dados, onde informações são armazenadas de forma estruturada. "
					+ "Utilizado para armazenar, organizar e recuperar dados em aplicações, com exemplos como MySQL, "
					+ "PostgreSQL e Oracle.",
					"ARMAZENAMENTO"
			));
		repository.save(new Course(
					"Python",
					"É uma linguagem de programação de alto nível, conhecida por sua simplicidade e "
					+ "legibilidade. Amplamente utilizada em diversas áreas, incluindo desenvolvimento web, "
					+ "ciência de dados, automação, inteligência artificial, entre outros.",
					"VERSÁTIL"	
			));		
		
	}
	
}
