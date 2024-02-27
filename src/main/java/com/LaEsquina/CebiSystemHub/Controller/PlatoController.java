package com.LaEsquina.CebiSystemHub.Controller;

import com.LaEsquina.CebiSystemHub.Model.Plato;
import com.LaEsquina.CebiSystemHub.Service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Plato>> getAllPlatos() {
        List<Plato> platos = platoService.getAllPlato();
        return new ResponseEntity<>(platos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Plato> getPlatoById(@PathVariable Long id) {
        Plato plato = platoService.getByIdPlato(id);
        if (plato != null) {
            return new ResponseEntity<>(plato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Plato> savePlato(@RequestBody Plato plato) {
        Plato savedPlato = platoService.savePlato(plato);
        return new ResponseEntity<>(savedPlato, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plato> updatePlato(@PathVariable Long id, @RequestBody Plato plato) {
        Plato updatedPlato = platoService.updatePlato(id, plato);
        if (updatedPlato != null) {
            return new ResponseEntity<>(updatedPlato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> deletePlato(@PathVariable Long id) {
        platoService.deletePlato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
