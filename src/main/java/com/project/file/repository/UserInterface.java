package com.project.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.file.login.model.Usuario;

@Repository
public interface UserInterface extends JpaRepository<Usuario, Integer> {
	
}
