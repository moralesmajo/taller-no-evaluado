package com.grupo13.ParcialNCapas.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo13.ParcialNCapas.models.dtos.AddSongToPlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.SaveSongDTO;
import com.grupo13.ParcialNCapas.models.entities.Song;
import com.grupo13.ParcialNCapas.services.SongServices;

@Service
public class SongServicesImpl
	implements SongServices{

	@Override
	public void save(SaveSongDTO info) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Song findByCode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSongToPlaylist(AddSongToPlaylistDTO info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Song> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
