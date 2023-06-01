package com.grupo13.ParcialNCapas.repositories;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.Playlist;


public interface PlaylistRepository
	extends ListCrudRepository<Playlist, UUID>{
	
	Optional<Playlist> findByTitle(String title);
	
	Playlist findByCode(UUID playlistCode);
	
	List<Playlist> findByUserCode(UUID userId);
	


}
