package com.LaEsquina.CebiSystemHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_usuario")
public class UserImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImage_Usuario")
    private Long idImageUsuario;

    @Column(name = "ID_Usuario")
    private Long idUsuario;

    @Column(name = "imagen")
    private String imagen;

	public Long getIdImageUsuario() {
		return idImageUsuario;
	}

	public void setIdImageUsuario(Long idImageUsuario) {
		this.idImageUsuario = idImageUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

    // Constructor, getters y setters
    
    
}