package com.eyecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller 
public class Index {
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/sobre")
	public String sobrenos() {
		return "sobre";
	}
	
	@GetMapping("/cursos")
	public String cursos() {
		return "cursos";
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


}

