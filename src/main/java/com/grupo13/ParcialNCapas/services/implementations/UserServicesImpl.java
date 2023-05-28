package com.grupo13.ParcialNCapas.services.implementations;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo13.ParcialNCapas.models.dtos.RegisterUserDTO;
import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.repositories.UserRepository;
import com.grupo13.ParcialNCapas.services.UserServices;

import jakarta.transaction.Transactional;

public class UserServicesImpl 
	implements UserServices	{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void register(RegisterUserDTO info) throws Exception {
		User user = new User(
				info.getUsername(),
				info.getEmail(),
				info.getPassword()
				);
		
		userRepository.save(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		try
		{
			UUID code = UUID.fromString(id);
			return userRepository.findById(code)
					.orElse(null);
			
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll(); 
	}
	
	
	

}
