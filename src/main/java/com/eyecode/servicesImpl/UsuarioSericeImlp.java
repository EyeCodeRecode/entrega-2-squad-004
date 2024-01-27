package com.eyecode.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eyecode.entities.Usuario;
import com.eyecode.repositories.UserRepository;
import com.eyecode.services.UsuarioService;





@Service
public class UsuarioSericeImlp implements UsuarioService{

	@Autowired
	private UserRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario getUsuarioById(Long id) {
	return usuarioRepository.findById (id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente != null) {
		usuarioExistente.setNome(usuarioAtualizado.getNome());
		return usuarioRepository.save(usuarioExistente);
	} else {
		throw new RuntimeException("Usuário com o ID" + id +  "não encontrado!");
		}
	}

	@Override
	public void deleteUsuario(long id) {
		usuarioRepository.deleteById(id);
		
	}

}
