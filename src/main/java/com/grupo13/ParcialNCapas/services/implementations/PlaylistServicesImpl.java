package com.grupo13.ParcialNCapas.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo13.ParcialNCapas.models.dtos.PlaylistDTO;
import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.services.PlaylistServices;

@Service
public class PlaylistServicesImpl 
	implements PlaylistServices{

	@Override
	public void save(PlaylistDTO info, User user_code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Playlist findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Playlist> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Playlist> findAllByUserId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
