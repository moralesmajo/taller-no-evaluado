package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class changeNamePLaylistDTO {
	
	@Id
	@NotEmpty
	private String playlistId;
	
	@NotEmpty
	private String oldName;
	
	@NotEmpty
	private String newName;
}
