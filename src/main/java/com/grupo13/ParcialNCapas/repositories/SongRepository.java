package com.grupo13.ParcialNCapas.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.grupo13.ParcialNCapas.models.entities.Song;

public interface SongRepository
	extends ListCrudRepository<Song,String>{
	
		Song findByTitle(String title);

}
