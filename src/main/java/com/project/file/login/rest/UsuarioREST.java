package com.project.file.login.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.file.login.model.Login;
import com.project.file.login.model.Usuario;
import com.project.file.repository.UserInterface;
import com.project.file.security.Encrypt;

public class UsuarioREST {

	public Usuario login(@RequestBody Login login, UserInterface userInterface) {
		List<Usuario> users = listarTodos(userInterface);
		Encrypt ec = new Encrypt();
		
		String hex = ec.passEncrypt(login.getSenha());
		
		System.out.println(hex);
		
		Usuario usuario = users.stream().
				filter(usu -> usu.getLogin().equals(login.getLogin()) &&
						usu.getSenha().equals(hex)).
				findAny().orElse(null);
		
		return usuario;
	}
	
	public List<Usuario> listarTodos(UserInterface userInterface) {
        return userInterface.findAll();
    }
	
	public Usuario buscarPorId(int id, UserInterface userInterface) {
		List<Usuario> users = listarTodos(userInterface);
		Usuario usuario = users.stream().
				filter(usu -> usu.getId() == id).
				findAny().orElse(null);
		return usuario;
	}
	
	
	public Usuario inserir(Usuario user, UserInterface userInterface) {
		List<Usuario> users = listarTodos(userInterface);
		
		Encrypt ec = new Encrypt();
		String hex = ec.passEncrypt(user.getSenha());
		
		user.setSenha(hex);
		
		Usuario u = users.parallelStream()
						.filter(usu -> usu.getLogin().equals(user.getLogin()))
						.findAny()
						.orElse(null);
		
		if(u == null) userInterface.save(user); 
		
		return user;
	}
	
	public ResponseEntity<Usuario> remover(int id, UserInterface userInterface) {
		List<Usuario> users = listarTodos(userInterface);
		Usuario u = users.parallelStream()
						.filter(usu -> usu.getId() == id)
						.findAny()
						.orElse(null);
		
		if(u != null) userInterface.delete(u);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Usuario> alterar(Usuario user, UserInterface userInterface) {
		List<Usuario> users = listarTodos(userInterface);
		Usuario usuario = users.stream().
				filter(usu -> usu.getId() == user.getId()).
				findAny().orElse(null);
		
		Encrypt ec = new Encrypt();
		String hex = ec.passEncrypt(user.getSenha());
		user.setSenha(hex);
		
		if(!user.getNome().isEmpty() && user.getNome() != null) usuario.setNome(user.getNome());
		if(!user.getLogin().isEmpty() && user.getLogin() != null) usuario.setLogin(user.getLogin());
		if(!user.getSenha().isEmpty() && user.getSenha() != null) usuario.setSenha(user.getSenha());
		if(!user.getPerfil().isEmpty() && user.getPerfil() != null) usuario.setPerfil(user.getPerfil());
		
		userInterface.save(usuario);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
		
}