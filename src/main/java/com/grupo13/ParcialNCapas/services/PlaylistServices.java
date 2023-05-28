package com.grupo13.ParcialNCapas.services;

import java.util.List;

import com.grupo13.ParcialNCapas.models.dtos.PlaylistDTO;
import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.User;

public interface PlaylistServices {

	void save (PlaylistDTO info , User user_code) throws Exception;
	Playlist findById(String id);
	List<Playlist> findAll();
	List<Playlist> findAllByUserId(String id);
	
}
