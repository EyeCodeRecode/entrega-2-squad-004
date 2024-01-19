package com.eyecode.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eyecode.entities.User;
import com.eyecode.repositories.UserRepository;
import com.eyecode.services.UsuarioService;





@Service
public class UsuarioSericeImlp implements UsuarioService{

	@Autowired
	private UserRepository usuarioRepository;
	
	@Override
	public List<User> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User getUsuarioById(Long id) {
	return usuarioRepository.findById (id).orElse(null);
	}

	@Override
	@Transactional
	public User saveUsuario(User usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public User updateUsuario(Long id, User usuarioAtualizado) {
		User usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente != null) {
		usuarioExistente.setName(usuarioAtualizado.getName());
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
