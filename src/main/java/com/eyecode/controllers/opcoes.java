package com.eyecode.controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

public class opcoes {
	
	@GetMapping("/home")
	public String home(@CookieValue(value = "fontSize", defaultValue = "16") String fontSize,
	                      @CookieValue(value = "modoEscuro", defaultValue = "false") String modoEscuro,
	                      Model model) {
	    // Converta os valores do cookie para tipos de dados apropriados
	    Integer fontSizeValue = Integer.parseInt(fontSize);
	    Boolean modoEscuroValue = Boolean.parseBoolean(modoEscuro);

	    // Exemplo de como você pode usar os valores convertidos
	    System.out.println("Tamanho da Fonte (Página 1): " + fontSizeValue);
	    System.out.println("Modo Escuro (Página 1): " + modoEscuroValue);

	    // Aqui você pode realizar qualquer lógica de processamento adicional, se necessário

	    // Adicione os valores convertidos ao modelo para serem usados na página
	    model.addAttribute("fontSize", fontSizeValue);
	    model.addAttribute("modoEscuro", modoEscuroValue);

	    return "home";
	}
}
