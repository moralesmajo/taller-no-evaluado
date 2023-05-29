package com.grupo13.ParcialNCapas.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	
	private String userName;
	@Email
	private String email;
	
	@Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
	private String password;
	//TODO: encrypt password

}
