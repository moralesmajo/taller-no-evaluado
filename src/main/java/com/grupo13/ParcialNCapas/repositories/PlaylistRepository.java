package com.grupo13.ParcialNCapas.repositories;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.User;

public interface PlaylistRepository
	extends ListCrudRepository<Playlist, UUID>{
	
	Optional<Playlist> findByTitle(String title);
	
	List<Playlist> findAllByUserId(User user);
	

}
