package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{2}\\d{4}$")
	@Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
	private String password;
	//TODO: encrypt password

}
