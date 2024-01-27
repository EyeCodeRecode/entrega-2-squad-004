package com.eyecode.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> users = new ArrayList<>();

	
	public Role() {
		
	}

	public Role(String authority) {
		this.authority = authority;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public List<Usuario> getUsuarios() {
		return users;
	}


	public void setUsuarios(List<Usuario> users) {
		this.users = users;
	}
	
	
}
