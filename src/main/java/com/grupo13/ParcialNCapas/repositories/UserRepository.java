package com.grupo13.ParcialNCapas.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.User;

public interface UserRepository 
	extends ListCrudRepository<User,UUID> {

}
