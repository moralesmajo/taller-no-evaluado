package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserDTO {
	
	@NotEmpty
	private String username;
		

	@NotEmpty
	@Email
	private String email;


		
	@NotEmpty
	private String password;
}
