package com.LaEsquina.CebiSystemHub.Service;

import com.LaEsquina.CebiSystemHub.Model.Usuario;
import java.util.List;

public interface UsuarioService {

    // Método para guardar un usuario
    Usuario saveUsuario(Usuario usuario);

    // Método para actualizar un usuario existente
    Usuario updateUsuario(Usuario usuario);

    // Método para eliminar un usuario por su ID
    boolean deleteUsuarioById(Long id);

    // Método para buscar un usuario por su ID
    Usuario getUsuarioById(Long id);

    // Método para buscar todos los usuarios
    List<Usuario> getAllUsuarios();

    // Método para buscar todos los usuarios activos
    List<Usuario> getUsuariosActivos();
}
