package com.eyecode.servicesImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eyecode.entities.Role;
import com.eyecode.entities.Usuario;
import com.eyecode.repositories.UserRepository;
import com.eyecode.services.UsuarioService;


@Service
public class UsuarioSericeImlp implements UsuarioService , UserDetailsService{

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Usuario user = usuarioRepository.findByName(username);
		System.out.print("\n - " + user.getNome() );
		
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(user.getNome(), user.getSenha(),
					mapRolesToAuthorities(user.getRoles()));
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado");

		}
		
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities (Collection<Role> roles) {
		  Collection<? extends GrantedAuthority> mapRoles = roles.stream()
		      .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
		      .collect(Collectors.toList());

		  return mapRoles;
		}
 

}
