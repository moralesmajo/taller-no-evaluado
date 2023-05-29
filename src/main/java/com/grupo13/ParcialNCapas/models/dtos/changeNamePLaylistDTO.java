package com.grupo13.ParcialNCapas.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class changeNamePLaylistDTO {
	
	private String playlistId;
	private String oldName;
	private String newName;

}
