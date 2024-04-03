package com.LaEsquina.CebiSystemHub.Controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.LaEsquina.CebiSystemHub.Model.UserImage;
import com.LaEsquina.CebiSystemHub.Service.UploadFileService;
import com.LaEsquina.CebiSystemHub.Service.UserImageService;

@RestController
@RequestMapping("/api/user-images")
public class UserImageController {

    @Autowired
    private UserImageService userImageService;
    
    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("userId") Long userId,
                                         @RequestParam("image") MultipartFile image) {
        try {
            // Guardar la imagen y obtener su nombre o ruta
            String imageName = uploadFileService.copy(image); // Lógica para guardar la imagen

            // Crear una nueva instancia de UserImage
            UserImage userImage = new UserImage();
            userImage.setIdUsuario(userId);
            userImage.setImagen(imageName);

            // Guardar la imagen de usuario
            userImageService.saveUserImage(userImage);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

  
    // Otros métodos según sea necesario...
}