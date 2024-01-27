package com.eyecode.services;

import java.util.List;

import com.eyecode.entities.Usuario;

public interface UsuarioService {
	List<Usuario> getAllUsuarios ();
	
	Usuario getUsuarioById (Long id);
	
	Usuario saveUsuario (Usuario usuario);
	
	Usuario updateUsuario (Long id, Usuario usuarioAtualizado);
	
	void deleteUsuario (long id);



}