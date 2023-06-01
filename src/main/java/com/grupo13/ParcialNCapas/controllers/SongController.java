package com.grupo13.ParcialNCapas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.grupo13.ParcialNCapas.models.dtos.SongsDTO;

import com.grupo13.ParcialNCapas.services.SongServices;
import com.grupo13.ParcialNCapas.utils.SongsConvert;


@RestController
@RequestMapping("/song")
@CrossOrigin("*")
public class SongController {
	
	@Autowired
	private SongServices songServices;
	@Autowired
	SongsConvert songsConvert;
	@GetMapping("/")
	public ResponseEntity<?> SearchSongs(@RequestParam(value = "title", required = false) String titleFragment){
		if(titleFragment!=null) {
			System.out.println("Si llego2");
			List<SongsDTO> convertedSongs = songsConvert.convertSecondsToMinutes(songServices.searchSongByKeyword(titleFragment));
			return new ResponseEntity<>(
					convertedSongs,
					HttpStatus.OK
				);
		}else {
			List<SongsDTO> convertedSongs = songsConvert.convertSecondsToMinutes(songServices.findAll());
			return new ResponseEntity<>(
					convertedSongs,
					HttpStatus.OK
				);
		}
	}
	
	
	
	
	
}