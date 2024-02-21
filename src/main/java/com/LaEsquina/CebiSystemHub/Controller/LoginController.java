package com.LaEsquina.CebiSystemHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LaEsquina.CebiSystemHub.Model.LoginRequest;
import com.LaEsquina.CebiSystemHub.Service.LoginRequestService;

@RestController
@RequestMapping("/usuario")
public class LoginController {

    @Autowired
    private LoginRequestService loginRequestService;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        LoginRequest user = loginRequestService.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && user.isActive()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else if (user != null && !user.isActive()) {
            return new ResponseEntity<>("El usuario no está activo", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
}
