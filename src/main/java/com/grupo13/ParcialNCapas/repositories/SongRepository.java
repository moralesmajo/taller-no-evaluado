package com.grupo13.ParcialNCapas.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.Song;

public interface SongRepository
	extends ListCrudRepository<Song,UUID>{
	
		Song findByTitle(String title);

}
