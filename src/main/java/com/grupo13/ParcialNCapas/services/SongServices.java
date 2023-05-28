package com.grupo13.ParcialNCapas.services;

import java.util.List;


import com.grupo13.ParcialNCapas.models.dtos.AddSongToPlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.SaveSongDTO;
import com.grupo13.ParcialNCapas.models.entities.Song;


public interface SongServices {
	
	void save(SaveSongDTO info) throws Exception;
	Song findByCode(String id);
	void addSongToPlaylist(AddSongToPlaylistDTO info);
	List<Song> findAll();
	
	//TODO: dada una palabra que se encuntren canciones similares

}
