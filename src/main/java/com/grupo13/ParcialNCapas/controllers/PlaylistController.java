package com.grupo13.ParcialNCapas.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo13.ParcialNCapas.models.dtos.AddSongDTO;
import com.grupo13.ParcialNCapas.models.dtos.AddSongToPlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.GetPlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.PlaylistDTO;
import com.grupo13.ParcialNCapas.models.dtos.PlaylistDetailsDTO;
import com.grupo13.ParcialNCapas.models.dtos.ResponseDTO;
import com.grupo13.ParcialNCapas.models.entities.Playlist;
import com.grupo13.ParcialNCapas.models.entities.Song;

import com.grupo13.ParcialNCapas.models.entities.User;
import com.grupo13.ParcialNCapas.services.PlaylistServices;
import com.grupo13.ParcialNCapas.services.SongServices;
import com.grupo13.ParcialNCapas.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class PlaylistController {
	
	@Autowired
	PlaylistServices playlistServices;
	
	@Autowired
	SongServices songServices;
	
	@Autowired
	UserServices userServices;
	
	@PostMapping("/playlist")
	private ResponseEntity<?> createPlaylist(@RequestBody @Valid PlaylistDTO info, BindingResult valid)
			throws Exception {
		
		if (valid.hasErrors()) 	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		User user = userServices.findByName(info.getIdentifier());
		System.out.println(user);

		if (user == null) {
			ResponseDTO response = new ResponseDTO();
			response.setMessage("El usuario no encontrado");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {

			boolean request = playlistServices.save(info, user);
			if (!request) {
				ResponseDTO response = new ResponseDTO();
				response.setMessage("Ya tienes una Playlist con ese mismo nombre");
				return new ResponseEntity<>(response,HttpStatus.CONFLICT);
			} else {
				ResponseDTO response = new ResponseDTO();
				response.setMessage("Creacion de playlist exitosa");
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			}

		}

	}
		
		
		@PostMapping("/playlist/")
		private ResponseEntity<?> AddSongToPlaylist(@RequestParam("playlistCode") String playlistCode,
				@RequestBody @Valid AddSongDTO info, BindingResult valid) throws Exception {
			System.out.println("Si llego");
			System.out.println(playlistCode);

			if (valid.hasErrors()) {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			AddSongToPlaylistDTO song = new AddSongToPlaylistDTO();
			song.setPlaylistCode(playlistCode);
			song.setSongCode(info.getCodeSong());

			System.out.println(song);
			boolean agregate = playlistServices.addSongToPlaylist(song);

			if (agregate == false) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {

				ResponseDTO message = new ResponseDTO();
				message.setMessage("Se agrego la cancion correctamente");
				return new ResponseEntity<>(message, HttpStatus.OK);
			}

		}
		
		@GetMapping("/all")
		public ResponseEntity<?> findAllSongs(@RequestParam("playlistCode") String playlistCode) throws Exception{
			System.out.println("hay canciones");
			List<Song> songs = playlistServices.findSongsByPlaylistCode(playlistCode);
			return new ResponseEntity<>(
					songs,
					HttpStatus.OK
				);
		}
		
		
		@GetMapping("/playlist/code")
		public ResponseEntity<?> getDetailsPlaylist(@RequestParam("playlistCode") String playlistCode) {
		    try {
		        PlaylistDetailsDTO newPlaylistDetails = playlistServices.getPlaylistDetails(playlistCode);
		        return new ResponseEntity<>(newPlaylistDetails, HttpStatus.OK);
		    }  catch (Exception e) {
		        ResponseDTO message = new ResponseDTO();
		        message.setMessage("Ocurrió un error inesperado");
		        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		}
		
		
		@GetMapping("/user/playlist")
		public ResponseEntity<?> findAllSongsByUsername(@RequestBody @Valid GetPlaylistDTO info,  BindingResult valid) throws Exception{
			
			if (valid.hasErrors()) {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			if(info.getKeyword() == null) {
				
				List<Playlist> playlist = playlistServices.findAllByUserId(info.getIdentifier());
				
				return new ResponseEntity<>(
						playlist ,
						HttpStatus.OK
					);
			}else {
				List<Playlist> filterPlaylist = playlistServices.searchPlaylistsByKeyword(info.getIdentifier(),info.getKeyword());
				return new ResponseEntity<>(
						filterPlaylist,
						HttpStatus.OK
					);
			}
			
		}
		
		
}
			
 
	


