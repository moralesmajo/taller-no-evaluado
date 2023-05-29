package com.grupo13.ParcialNCapas.repositories;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.User;

public interface UserRepository 
	extends ListCrudRepository<User,UUID> {
	
	boolean existsByUsername(String username);
    boolean existsByEmail(String email);
	
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	
}
