package com.project.file.service.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.file.controller.SessionController;

@CrossOrigin
@RestController
public class SessionService {

	@GetMapping("/load")
	List<Object> listarTodosService() {
		SessionController sessionController =  new SessionController();
		return sessionController.getProperties();
	}
	
}
