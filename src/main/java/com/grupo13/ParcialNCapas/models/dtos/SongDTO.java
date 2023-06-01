package com.grupo13.ParcialNCapas.models.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
	private String title;
    private String duration;
    private Date addedDate;
}
