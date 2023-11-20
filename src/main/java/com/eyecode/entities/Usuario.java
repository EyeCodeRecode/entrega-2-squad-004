package com.eyecode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	@Column(columnDefinition = "TEXT")
	private String deficiencia;
	@Column(columnDefinition = "TEXT")
	private String preferencia;
	
	
	public Usuario() {
		
	}
	
	
	public Usuario(Long id, String nome, String login, String senha, String email, String deficiencia,
			String preferencia) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.deficiencia = deficiencia;
		this.preferencia = preferencia;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDeficiencia() {
		return deficiencia;
	}


	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}


	public String getPreferencia() {
		return preferencia;
	}


	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

}

