package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSongToPlaylistDTO {
	
	@NotEmpty
	private String playlistCode;
	
	@NotEmpty
	private String songCode;
}
