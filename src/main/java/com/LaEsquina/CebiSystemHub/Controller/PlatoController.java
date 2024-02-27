package com.LaEsquina.CebiSystemHub.Controller;

import com.LaEsquina.CebiSystemHub.Model.Plato;
import com.LaEsquina.CebiSystemHub.Model.PlatoResponse;
import com.LaEsquina.CebiSystemHub.Service.PlatoService;
import com.LaEsquina.CebiSystemHub.Service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;





import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.util.ArrayList;




import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @Autowired
    private UploadFileService uploadFileService;
    
    @Autowired
    public PlatoController(PlatoService platoService, UploadFileService uploadFileService) {
        this.platoService = platoService;
        this.uploadFileService = uploadFileService;
    }

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
    public ResponseEntity<Plato> savePlato(@RequestPart("plato") @Valid Plato plato,
            @RequestPart("file") MultipartFile image) {
        try {
            // Guardar la imagen y obtener su nombre
            String imageName = uploadFileService.copy(image);
            // Establecer el nombre de la imagen en el objeto Plato
            plato.setImagen(imageName);
            // Guardar el plato en la base de datos
            Plato savedPlato = platoService.savePlato(plato);
            return new ResponseEntity<>(savedPlato, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plato> updatePlato(@PathVariable Long id, @Valid @RequestBody Plato plato) {
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
    
    
    
    @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> loadImage(@PathVariable String imageName) {
        try {
            Resource resource = uploadFileService.load(imageName);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/listari")
    public ResponseEntity<List<PlatoResponse>> getAllPlatosWithImages() {
        List<PlatoResponse> platosConImagenes = new ArrayList<>();
        List<Plato> platos = platoService.getAllPlato();

        for (Plato plato : platos) {
            String imageUrl = "/static/images/" + plato.getImagen(); // Construye la URL de la imagen
            PlatoResponse platoResponse = new PlatoResponse(plato, imageUrl);
            platosConImagenes.add(platoResponse);
        }

        if (platosConImagenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(platosConImagenes);
        }
    }

    

}
