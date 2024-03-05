package com.LaEsquina.CebiSystemHub.ServiceImpl;

import com.LaEsquina.CebiSystemHub.Model.IdRequest;
import com.LaEsquina.CebiSystemHub.Model.Usuario;
import com.LaEsquina.CebiSystemHub.Repository.UsuarioRepository;
import com.LaEsquina.CebiSystemHub.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
		return false;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getUsuariosActivos() {
        return usuarioRepository.findAllByActivoTrue();
    }
    
    
    @Override
    public Optional<Usuario> buscarPorId(IdRequest idRequest) {
        Long id = idRequest.getId();
        return usuarioRepository.findById(id);
    }
    

 }
