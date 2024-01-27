package com.eyecode.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eyecode.entities.Usuario;
import com.eyecode.services.UsuarioService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public String listUsuarios (Model model) {
		List<Usuario> Usuarios = usuarioService.getAllUsuarios();
		model.addAttribute("users", Usuarios);
		return "ListarUsuarios";
	}

	//FORMULÁRIO DE CRIAÇÃO
	@GetMapping ("/novo")
	public String showFormForadd(Model model) {
		Usuario usuario = new Usuario ();
		model.addAttribute ("usuario", usuario);
		return "usuarioForm";
	}

//PERSISTENCIA DA CRIAÇÃO
	@PostMapping ("/save")
	public String saveUsuario (@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/usuarios";
	}


	@GetMapping("/editar/{id}") 
	public String exibirFormularioEdicao(@PathVariable("id") Long userId, Model model) {
	    Usuario usuario = usuarioService.getUsuarioById(userId);
	    model.addAttribute("usuario", usuario);
	    return "usuarioForm"; 
	}


	@PostMapping("/editar/{id}")
	public String editUser(@PathVariable("id") Long userId, @ModelAttribute("usuario") Usuario usuario) {
	    Usuario usuarioExistente = usuarioService.getUsuarioById(userId);
	
	   
	    usuarioService.updateUsuario(userId, usuarioExistente); 
	
	    return "redirect:/usuarios"; 
	}
	// EXCLUIR CATEGORIA
	@PostMapping("/deletar/{id}")
	public String deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/usuarios";
	}




}
