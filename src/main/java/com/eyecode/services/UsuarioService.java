package com.eyecode.services;

import java.util.List;

import com.eyecode.entities.User;

public interface UsuarioService {
	List<User> getAllUsuarios ();
	
	User getUsuarioById (Long id);
	
	User saveUsuario (User usuario);
	
	User updateUsuario (Long id, User usuarioAtualizado);
	
	void deleteUsuario (long id);



}