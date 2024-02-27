package com.LaEsquina.CebiSystemHub.Service;

import com.LaEsquina.CebiSystemHub.Model.Plato;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface PlatoService {
    List<Plato> getAllPlato();
    Plato getByIdPlato(Long id);
    Plato savePlato(Plato plato);
    Plato updatePlato(Long id, Plato plato);
    void deletePlato(Long id);
}
