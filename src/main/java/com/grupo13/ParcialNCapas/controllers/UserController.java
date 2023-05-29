package com.grupo13.ParcialNCapas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.services.UserServices;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllUser(){
		System.out.println("Si llego");
		List<User> users = userServices.findAll();	
		return new ResponseEntity<>(
				users,
				HttpStatus.OK
			);
	
	}

}
