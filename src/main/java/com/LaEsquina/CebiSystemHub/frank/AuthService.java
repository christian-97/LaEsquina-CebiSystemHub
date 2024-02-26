package com.LaEsquina.CebiSystemHub.frank;


import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getContrasena()));
        
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        User usuarioencontrado = userRepository.findByUsername(request.getUsername()).orElseThrow();

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.getToken(userDetails));
        authResponse.setNombreUsuario(userDetails.getUsername());
        authResponse.setUsuarioId(usuarioencontrado.getId());
        authResponse.setAuthorities(authorities);
        authResponse.setBearer("Bearer");

        return authResponse;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setNombre(request.getNombre());
        user.setContrasena(passwordEncoder.encode(request.getContrasena()));
        user.setApellido(request.getApellido());
        user.setCorreoElectronico(request.getCorreoElectronico());
        user.setTelefono(request.getTelefono());
        user.setCedula(request.getCedula());
        user.setEstado(request.isEstado());
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());

        userRepository.save(user);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        Collection<? extends GrantedAuthority> authorities = Collections.singletonList(authority);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.getToken(user));
        authResponse.setNombreUsuario(user.getUsername());
        authResponse.setAuthorities(authorities);
        authResponse.setBearer("Bearer");

        return authResponse;
    }  
}
