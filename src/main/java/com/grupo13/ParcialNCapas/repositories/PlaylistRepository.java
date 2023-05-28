package com.grupo13.ParcialNCapas.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.Playlist;

public interface PlaylistRepository
	extends ListCrudRepository<Playlist, UUID>{
	
	List<Playlist> findByTitle(String title);
	
	List<Playlist> findAllByUserId(String user_id);
	

}
