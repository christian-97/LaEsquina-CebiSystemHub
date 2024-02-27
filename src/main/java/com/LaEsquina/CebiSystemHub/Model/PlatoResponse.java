package com.LaEsquina.CebiSystemHub.Model;


public class PlatoResponse {
    private Plato plato;
    private String imageUrl;

    public PlatoResponse(Plato plato, String imageUrl) {
        this.plato = plato;
        this.imageUrl = imageUrl;
    }

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    // Getters y setters
    
}

