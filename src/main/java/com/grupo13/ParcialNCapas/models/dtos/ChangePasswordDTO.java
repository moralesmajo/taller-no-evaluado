package com.grupo13.ParcialNCapas.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDTO {
	
	private String id;
	private String oldPassword;
	private String newPassword; 

}
