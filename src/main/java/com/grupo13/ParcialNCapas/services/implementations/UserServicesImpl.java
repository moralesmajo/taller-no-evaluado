package com.grupo13.ParcialNCapas.services.implementations;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.ParcialNCapas.models.dtos.ChangePasswordDTO;
import com.grupo13.ParcialNCapas.models.dtos.LoginDTO;
import com.grupo13.ParcialNCapas.models.dtos.RegisterUserDTO;
import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.repositories.UserRepository;
import com.grupo13.ParcialNCapas.services.UserServices;

import jakarta.transaction.Transactional;

@Service
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
				info.getPassword() + "_encrypted"
				);
		
		userRepository.save(user);
		
		
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
		return userRepository.findAll(); 
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void changePassword(ChangePasswordDTO info) throws Exception {
		
		User user = findById(info.getId());
		
		if(user == null) throw new Exception("Usuario no econtrado");
		
		String password = removeEncryptedSuffix(user.getPassword());
		if(!password.equals(info.getOldPassword())) {
			throw new Exception("La contraseña del usuario no coincide");
			}else {
				String encrPassword = info.getNewPassword() + "_encrypted";
			user.setPassword(encrPassword);
			userRepository.save(user);
			}
	}

	@Override
	public User logIn(LoginDTO info) throws Exception {
		User user;
		if (info.getUserName() != null) {
			user = userRepository.findByUsername(info.getUserName());
					
		} else  {
			user = userRepository.findByEmail(info.getEmail());
			
		}
		
		if(user != null) {
			if (user.getPassword().equals(info.getPassword())) 
				return user;
	
		}
	
		
		return null;
		
	}
	
	private String removeEncryptedSuffix(String password) {
	    if (password.endsWith("_encrypted")) {
	        return password.substring(0, password.length() - "_encrypted".length());
	    }
	    return password;
	}

	@Override
	public void ChangeUserName(String username) throws Exception {
			// TODO Auto-generated method stub
		
	}

	@Override
	public User findByName(String name) {

		User user = userRepository.findByUsername(name);
		if (user != null)
			return user;
		user = userRepository.findByEmail(name);
		return user;

	}

}
