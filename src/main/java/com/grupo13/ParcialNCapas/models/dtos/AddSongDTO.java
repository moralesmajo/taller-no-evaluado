package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddSongDTO {
	
	@NotEmpty
	private String codeSong;

}
