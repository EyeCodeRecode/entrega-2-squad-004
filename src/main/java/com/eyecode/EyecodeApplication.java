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
import com.eyecode.entities.User;
import com.eyecode.repositories.ContactRepository;
import com.eyecode.repositories.CourseRepository;
import com.eyecode.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@SpringBootApplication
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
		
		
		User user = new User();
		
		user.setEmail("Cristianascimento@gmail.com");
		user.setName("Cristian");
		user.setPassword("password");
		
		ArrayList<Role> roles = new ArrayList<>();
		
		roles.add(new Role("ADMIM"));
		
		user.setRoles(roles);
		
		userRepository.save(user);
		
			
		String[] listName = {"Html.png" ,"Css.png","js.png","java.png","bd.png","phyton.png"}; 
		List<byte[]> listImgs = new ArrayList<byte[]>();
		
		for (String item : listName) {
			ClassPathResource  classPathResource = 
					new ClassPathResource("static\\img\\defaultImgs\\"+item);
			try {
				listImgs.add(StreamUtils.copyToByteArray(classPathResource.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
		}

		
		repository.save(new Course(
					"HTML",
					"É a linguagem de marcação padrão para a criação de páginas web. "
					+ "Utilizada para estruturar o conteúdo das páginas, define elementos como títulos, "
					+ "parágrafos, links, imagens, entre outros.",
					"ESTRUTURA",
					listImgs.get(0)
				));
		
		repository.save(new Course(
					"CSS",
					"É uma linguagem de estilo utilizada para definir a apresentação "
					+ "e o layout das páginas web. Permite estilizar elementos HTML, "
					+ "controlando cores, fontes, margens, posicionamento, entre outros.",
					"ESTILO",
					listImgs.get(1)

			));
		
		repository.save(new Course(
					"JAVASCRIPT",
					"É uma linguagem de programação de alto nível, amplamente utilizada "
					+ "no desenvolvimento web para criar interatividade e dinamismo nas páginas. "
					+ "Executada no navegador do usuário, possibilita manipular elementos da página e "
					+ "responder a eventos.",
					"INTERATIVIDADE",
					listImgs.get(2)

			));
		
		repository.save(new Course(
					"JAVA",
					"É uma linguagem de programação versátil e robusta, frequentemente utilizada no "
					+ "desenvolvimento de aplicações corporativas, sistemas web e móveis. Conhecida por "
					+ "ser orientada a objetos e pela portabilidade, pode ser executada em diferentes plataformas.",
					"VERSATILIDADE",
					listImgs.get(3)

			));		
		repository.save(new Course(
					"Banco de dados",
					"Refere-se a sistemas de gerenciamento de dados, onde informações são armazenadas de forma estruturada. "
					+ "Utilizado para armazenar, organizar e recuperar dados em aplicações, com exemplos como MySQL, "
					+ "PostgreSQL e Oracle.",
					"ARMAZENAMENTO",
					listImgs.get(4)

			));
		
		repository.save(new Course(
					"Python",
					"É uma linguagem de programação de alto nível, conhecida por sua simplicidade e "
					+ "legibilidade. Amplamente utilizada em diversas áreas, incluindo desenvolvimento web, "
					+ "ciência de dados, automação, inteligência artificial, entre outros.",
					"VERSÁTIL",
					listImgs.get(5)

			));		
		
		userRepository.findAll().forEach(item ->{
			System.out.print(
					"\n" + item.getName() +
					"\n" + item.getRoles().get(0).getAuthority()
					);
		});
		
	}
	
}
