package com.grupo13.ParcialNCapas.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.Playlist;

public interface PlaylistRepository
	extends ListCrudRepository<Playlist, String>{
	
	List<Playlist> findByTitle(String title);

}
