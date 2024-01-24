package com.eyecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cursos")
public class CursoCntroller {
	
	@GetMapping
	public String cursos() {
	
		return "cursos";
	}
	
	@GetMapping("/html")
	public String html() {
		return "cursoHtml.html";
	}
	
	@GetMapping("/css")
	public String css() {
		return "";
	}
	
	@GetMapping("/javascript")
	public String javascript() {
		return "";
	}
	
	@GetMapping("/java")
	public String ava() {
		return "";
	}
	
	@GetMapping("/bd")
	public String bd() {
		return "";
	}
	
	@GetMapping("/python")
	public String python() {
		return "";
	}

	
}
