package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeNameSongDTO {
	
	@Id
	@NotEmpty
	private String songId;
	
	@NotEmpty
	private String oldName;
	
	@NotEmpty
	private String newName;
}
