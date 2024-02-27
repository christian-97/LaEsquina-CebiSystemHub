package com.LaEsquina.CebiSystemHub.Service;

import com.LaEsquina.CebiSystemHub.Model.Plato;

import java.util.List;

public interface PlatoService {
    List<Plato> getAllPlato();
    Plato getByIdPlato(Long id);
    Plato savePlato(Plato plato);
    Plato updatePlato(Long id, Plato plato);
    void deletePlato(Long id);
}
