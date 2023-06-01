package com.grupo13.ParcialNCapas.services.implementations;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.ParcialNCapas.models.dtos.ChangeNameSongDTO;
import com.grupo13.ParcialNCapas.models.dtos.SaveSongDTO;
import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.Song;
import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.repositories.SongRepository;
import com.grupo13.ParcialNCapas.services.SongServices;

import jakarta.transaction.Transactional;

@Service
public class SongServicesImpl
	implements SongServices{
	
	@Autowired
	SongRepository songRepository;
	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void save(SaveSongDTO info) throws Exception {
		 Song song = new Song(
				 info.getTitle(),
				 info.getDuration());
		 
		    songRepository.save(song);
		
	}
	
	@Override
	public Song findById(String id) {
		try {
			UUID songId = UUID.fromString(id);
		    return songRepository.findById(songId).orElse(null);
		}catch(Exception e)
		{
			return null;
		}
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteSong(String id) throws Exception {
	    Song song  = findById(id);
	    if(song == null)
	    {
	    	throw new Exception("La cancion no existe");
	    }else {
	    	songRepository.deleteById(song.getCode());
	    	System.out.println("Cancion eliminada con exito!!");
	    }
	    		
		
	}

	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void changeNameToSong(ChangeNameSongDTO info) throws Exception {
		 
		Song song = findById(info.getSongId());
		if(song == null) throw new Exception("La canción no existe");
		
		if(!song.getTitle().equals(info.getOldName())) throw new Exception("El nombre actual de la cancion no coinicide , no se llevo a cabo el cambio ");
		
		song.setTitle(info.getNewName());
	    songRepository.save(song);
		
	}

	@Override
	public List<Song> findAll() {
		return songRepository.findAll();
	}


	@Override
	public List<Song> searchSongByKeyword(String keyword) {
	
		 List<Song> songsList = songRepository.findAll();
		 
	        List<Song> matchingSong = new ArrayList<>();

	        for (Song songs : songsList) {
	            if (songs.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
	            	matchingSong.add(songs);
	            }
	        }

	        return matchingSong;
	}

}
