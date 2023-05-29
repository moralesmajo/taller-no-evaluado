package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDTO {
	
	@Id
	@NotEmpty
	private String id;
	
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{2}\\d{4}$")
	private String oldPassword;
	
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{2}\\d{4}$")
	private String newPassword; 

}
