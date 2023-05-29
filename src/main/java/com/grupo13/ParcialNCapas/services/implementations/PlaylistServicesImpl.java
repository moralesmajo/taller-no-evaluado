package com.grupo13.ParcialNCapas.services.implementations;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.ParcialNCapas.models.dtos.AddSongToPlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.PlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.changeNamePLaylistDTO;
import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.Song;
import com.grupo13.ParcialNCapas.models.entities.SongXPlaylist;
import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.repositories.PlaylistRepository;
import com.grupo13.ParcialNCapas.repositories.SongRepository;
import com.grupo13.ParcialNCapas.repositories.UserRepository;
import com.grupo13.ParcialNCapas.services.PlaylistServices;

import jakarta.transaction.Transactional;

@Service
public class PlaylistServicesImpl implements PlaylistServices {

	@Autowired
	PlaylistRepository playlistRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SongRepository songRepository;
	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void save(PlaylistDTO info, User user) throws Exception {
		Playlist playlist = new Playlist(

				info.getTitle(), info.getDescription(), user);

		playlistRepository.save(playlist);

	}

	@Override
	public Playlist findById(String id) {
		try {
			UUID code = UUID.fromString(id);
			return playlistRepository.findById(code).orElse(null);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Playlist> findAll() {
		return playlistRepository.findAll();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<Playlist> findAllByUserId(String id) throws Exception {
		try {
			UUID userId = UUID.fromString(id);
			User user = userRepository.findById(userId).orElseThrow(() -> new Exception("Usuario no encontrado"));

			return playlistRepository.findAllByUser(user);
		} catch (IllegalArgumentException e) {
			throw new Exception("ID ingresado no valido");
		} catch (Exception e) {
			throw new Exception("Error al buscr playlist" + e.getMessage());
		}
	}

	@Override
	public Playlist findByTitle(String title) {

		try {
			return playlistRepository.findByTitle(title).orElseGet(() -> null);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void changePlaylistName(changeNamePLaylistDTO info) throws Exception {
		Playlist play = findById(info.getPlaylistId());
		if (play == null) {
			throw new Exception("playlist no encontrada");
		}

		if (!play.getTitle().equals(info.getOldName())) {
			throw new Exception("La contraseña antigua es incorrecta");
		} else {
			play.setTitle(info.getNewName());
			playlistRepository.save(play);
		}

	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deletePLaylist(String id) throws Exception {
		try {
			UUID playlistId = UUID.fromString(id);
			Playlist playlist = playlistRepository.findById(playlistId)
					.orElseThrow(() -> new Exception("Playlist no encontrada"));

			playlistRepository.delete(playlist);
		} catch (IllegalArgumentException e) {
			throw new Exception("Id de playlist invalido");
		} catch (Exception e) {
			throw new Exception("Eroor al eliminar playlist " + e.getMessage());
		}
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<Song> findSongsByPlaylistCode(String id) throws Exception {
		UUID code = UUID.fromString(id);
		Playlist playlist = playlistRepository.findById(code)
				.orElseThrow(() -> new RuntimeException("Playlist not found"));

		return playlist.getSongs().stream().map(SongXPlaylist::getSong).collect(Collectors.toList());
	}

	@Override
	public int TotalDurationOfPlaylist(String id) {
		UUID code = UUID.fromString(id);
		int totalDuration = 0;

		Playlist playlist = playlistRepository.findById(code)
				.orElseThrow(() -> new IllegalArgumentException("Playlist no encontrada"));

		for (SongXPlaylist songXPlaylist : playlist.getSongs()) {
			totalDuration += songXPlaylist.getSong().getDuration();
		}

		return totalDuration;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void addSongToPlaylist(AddSongToPlaylistDTO info) throws Exception {
		
		UUID playlistCode = UUID.fromString(info.getPlaylistCode());
		Playlist playlist = playlistRepository.findById(playlistCode)
				.orElseThrow(() -> new IllegalArgumentException("Playlist no encontrada"));
		
		UUID songCode  = UUID.fromString(info.getSongCode());
		Song song = songRepository.findById(songCode)
				.orElseThrow(() -> new IllegalArgumentException("Cancion no encontrada"));
		
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = (Date) calendar.getTime();
		SongXPlaylist songXPlaylist = new SongXPlaylist(playlist, song, currentDate );
		
		playlist.getSongs().add(songXPlaylist);

	    playlistRepository.save(playlist);
		
		
		
	}

}
