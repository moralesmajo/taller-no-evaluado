package com.grupo13.ParcialNCapas.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"playlists"})
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@Column(name = "code")
    private String codigo;

    @NotNull
    @Column(name = "username")
    private String username;

    
    @Email(message = "El correo electrónico no es válido")
    @Column(name = "email")
    private String email;

    @NotNull
    @JsonIgnore
    @Column(name = "password")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Playlist> playlists;


    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
