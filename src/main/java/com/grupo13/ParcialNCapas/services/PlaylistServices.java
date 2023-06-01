package com.grupo13.ParcialNCapas.services;

import java.util.List;
import java.util.UUID;

import com.grupo13.ParcialNCapas.models.dtos.AddSongToPlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.PlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.PlaylistDetailsDTO;
import com.grupo13.ParcialNCapas.models.dtos.changeNamePLaylistDTO;
import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.Song;

import com.grupo13.ParcialNCapas.models.entities.User;



public interface PlaylistServices {

	boolean save (PlaylistDTO info , User user_code) throws Exception;
	void changePlaylistName(changeNamePLaylistDTO info)  throws Exception;
	boolean addSongToPlaylist(AddSongToPlaylistDTO info)  throws Exception;
	PlaylistDetailsDTO getPlaylistDetails(String playlistCode)  throws Exception;
	Playlist findById(String id);
	void deletePLaylist(String id)  throws Exception ;
	Playlist findByTitle(String title);
	List<Playlist> findAll();
	List<Playlist> searchPlaylistsByKeyword(String username, String keyword);
	List<Playlist> findAllByUserId(String id) throws Exception;
	List<Song> findSongsByPlaylistCode(String id) throws Exception;
	int TotalDurationOfPlaylist(String id);
	
	
}
