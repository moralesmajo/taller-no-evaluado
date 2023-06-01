package com.grupo13.ParcialNCapas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo13.ParcialNCapas.models.dtos.ChangePasswordDTO;
import com.grupo13.ParcialNCapas.models.dtos.LoginDTO;
import com.grupo13.ParcialNCapas.models.dtos.RegisterUserDTO;
import com.grupo13.ParcialNCapas.models.dtos.ResponseDTO;
import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.services.UserServices;

import jakarta.validation.Valid;

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
	
	@PostMapping("/")
	private ResponseEntity<?> logIng(@RequestBody @Valid LoginDTO info , BindingResult valid) throws Exception
	{
		if(valid.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userServices.logIn(info);
		if ( user == null) {
			ResponseDTO response = new ResponseDTO();
		       response.setMessage("intento de inicio de sesion fallido");
			 return new ResponseEntity<>( response, HttpStatus.NOT_FOUND);
		}else {
			ResponseDTO response = new ResponseDTO();
		       response.setMessage("Bienvenido :)");
		       return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@PostMapping("/register")
	private ResponseEntity<?> registerUser(@RequestBody @Valid RegisterUserDTO info , BindingResult valid) throws Exception
	{
		if(valid.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
			userServices.register(info);
			
			ResponseDTO response = new ResponseDTO();
		       response.setMessage("Registro exitoso");
		       return new ResponseEntity<>(response, HttpStatus.OK);
	}
		
	@PatchMapping("/change-password")
	public ResponseEntity<?> changePassword(@RequestBody @Valid ChangePasswordDTO info, BindingResult valid) throws Exception
	{
		User user = userServices.findById(info.getId());
		
		if(valid.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if (user== null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }else {
	    	userServices.changePassword(info);
	    	ResponseDTO response = new ResponseDTO();
		       response.setMessage("Cambio de contraseña exitoso");
		       return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	}
	
	
	

}
