package com.grupo13.ParcialNCapas.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;


@Entity
@Data
@ToString(exclude = {"songs"})
@NoArgsConstructor
public class Playlist {
	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @NotNull(message = "El título de la playlist es obligatorio")
    @Size(max = 25, message = "El título de la playlist debe tener como máximo 25 caracteres")
    @Column(name="title")
    private String title;

    @Size(max = 100, message = "La descripción de la playlist debe tener como máximo 100 caracteres")
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_code", nullable = true)
    private User user;
    
    @OneToMany(mappedBy = "playlist", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SongXPlaylist> songs;

    // Constructor
    public Playlist(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
    
}
