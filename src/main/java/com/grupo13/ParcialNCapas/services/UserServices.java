package com.grupo13.ParcialNCapas.services;

import java.util.List;

import com.grupo13.ParcialNCapas.models.dtos.ChangePasswordDTO;
import com.grupo13.ParcialNCapas.models.dtos.LoginDTO;
import com.grupo13.ParcialNCapas.models.dtos.RegisterUserDTO;
import com.grupo13.ParcialNCapas.models.entities.User;

public interface UserServices {
	
	void register (RegisterUserDTO info) throws Exception;
	void logIn (LoginDTO info) throws Exception;
	User findById(String id );
	void changePassword(ChangePasswordDTO info) throws Exception;
	List<User> findAll();

}
