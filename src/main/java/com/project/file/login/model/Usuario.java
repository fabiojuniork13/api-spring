package com.project.file.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tbspk001_user")
public class Usuario implements Serializable {
	
	private int id;
	private String nome;
	private String login;
	private String senha;
	private String perfil;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String login, String senha, String perfil) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	
	@Column(name = "senha")
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	
	@Column(name = "perfil")
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
