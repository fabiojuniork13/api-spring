package com.project.file.service.rest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.file.login.model.Login;
import com.project.file.login.model.Usuario;
import com.project.file.login.rest.UsuarioREST;
import com.project.file.repository.UserInterface;

@CrossOrigin
@RestController
public class UsuarioService {
	
	@Autowired
	private UserInterface userInterface;
//
//	public List<Usuario> getAllUsers() {
//        return userInterface.findAll();
//    }
	
	@PostMapping("/login")
	Usuario loginService(@RequestBody Login login) {
		UsuarioREST userController =  new UsuarioREST();
		return userController.login(login, userInterface);
	}

	@GetMapping("/login")
	List<Usuario> listarTodosService() {
		UsuarioREST userController =  new UsuarioREST();
		return userController.listarTodos(userInterface);
	}
	
	@GetMapping("/find/{id}")
	Usuario buscarPorIdService(@PathVariable("id") int id) {
		UsuarioREST userController =  new UsuarioREST();
		return userController.buscarPorId(id, userInterface);
	}
	
	
	@PostMapping("/insert")
	public Usuario inserirService(@RequestBody Usuario user) {
		UsuarioREST userController =  new UsuarioREST();
		return userController.inserir(user, userInterface);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Usuario> removerService(@PathVariable("id") int id) {
		UsuarioREST userController =  new UsuarioREST();
		return userController.remover(id, userInterface);
	}
	
	@PutMapping("/alter")
	public ResponseEntity<Usuario> alterarService(@RequestBody Usuario user) {
		UsuarioREST userController =  new UsuarioREST();
		return userController.alterar(user, userInterface);
	}
	
}
