package com.eyecode.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eyecode.entities.Course;
import com.eyecode.repositories.CourseRepository;

@Controller 
public class Index {
	
	@Autowired
	CourseRepository courseRepository; 
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/sobre")
	public String sobrenos() {
		return "sobre";
	}
	
	@GetMapping("/cursos")
	public ModelAndView cursos() {
		
		ModelAndView page = new ModelAndView("/cursos");
				
		return page;
	}
	
	
	@GetMapping("/opcoes")
	public String opcoes() {
		return "opcoes";
	}
	
	
	@GetMapping("/crud")
	public String crud() {
		return "usuarios";
	}
	
	
	@GetMapping("/pagcurso")
	public String pagcurso() {
		return "pagcurso";
	}
	
	
	@GetMapping("/pagcurso1")
	public String pagcurso1() {
		return "pagcurso1";
	}
	
	
	@GetMapping("/pagcurso2")
	public String pagcurso2() {
		return "pagcurso2";
	}
	
	
	@GetMapping("/pagcurso3")
	public String pagcurso3() {
		return "pagcurso3";
	}
	
	
	@GetMapping("/pagcurso4")
	public String pagcurso4() {
		return "pagcurso4";
	}
	
	
	@GetMapping("/pagcurso5")
	public String pagcurso5() {
		return "pagcurso5";
	}
	
	
	@GetMapping("/pagcurso6")
	public String pagcurso6() {
		return "pagcurso6";
	}

	@GetMapping("/listarUsuarios")
	public String lisingUser() {
		return "ListarUsuarios";
	}

	@GetMapping("/pages-faq")
	public String pagesfaq() {
		return "pages-faq";
	}
	
	@GetMapping("/fullcalendar")
	public String fullcalendar() {
		return "fullcalendar";
	}
	
	@GetMapping("/indexperfil")
	public String indexperfil() {
		return "indexperfil";
	}
	
	@GetMapping("/users-profile")
	public String usersprofile() {
		return "users-profile";
	}


}

