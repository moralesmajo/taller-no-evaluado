package com.grupo13.ParcialNCapas.services;

import java.util.List;

import com.grupo13.ParcialNCapas.models.dtos.ChangeNameSongDTO;
import com.grupo13.ParcialNCapas.models.dtos.SaveSongDTO;
import com.grupo13.ParcialNCapas.models.entities.Song;


public interface SongServices {
	
	void save(SaveSongDTO info) throws Exception;
	void deleteSong(String id) throws Exception;
	Song findById(String id);
	void changeNameToSong(ChangeNameSongDTO info) throws Exception;
	List<Song> findAllByName(String name);
	List<Song> findAll();
	
	//TODO: dada una palabra que se encuntren canciones similares

}
