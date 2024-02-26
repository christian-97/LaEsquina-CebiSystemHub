package com.LaEsquina.CebiSystemHub.frank;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public List<User> usuarios() {
        return usuarioRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public User buscarUsuarioId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public User guardarUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void cambioEstado(Long id, boolean estado) {

        User usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEstado(estado);
        usuarioRepository.save(usuario);
    }

    @Override
    public boolean existeCorreoElectronico(String correoElectronico) {
        return usuarioRepository.existsByCorreoElectronico(correoElectronico);
    }

 

}
