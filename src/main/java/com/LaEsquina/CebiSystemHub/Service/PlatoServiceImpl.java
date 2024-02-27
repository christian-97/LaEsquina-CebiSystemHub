package com.LaEsquina.CebiSystemHub.Service;

import com.LaEsquina.CebiSystemHub.Model.Plato;
import com.LaEsquina.CebiSystemHub.Repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Override
    public List<Plato> getAllPlato() {
        return platoRepository.findAll();
    }

    @Override
    public Plato getByIdPlato(Long id) {
        Optional<Plato> optionalPlato = platoRepository.findById(id);
        return optionalPlato.orElse(null);
    }

    @Override
    public Plato savePlato(Plato plato) {
        return platoRepository.save(plato);
    }

    @Override
    public Plato updatePlato(Long id, Plato plato) {
        if (platoRepository.existsById(id)) {
            plato.setId(id);
            return platoRepository.save(plato);
        }
        return null; // O manejar de otra manera si el plato no existe
    }

    @Override
    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }
}
