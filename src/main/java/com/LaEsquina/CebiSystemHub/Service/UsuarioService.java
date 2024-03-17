package com.LaEsquina.CebiSystemHub.Service;

import com.LaEsquina.CebiSystemHub.Model.IdRequest;
import com.LaEsquina.CebiSystemHub.Model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    
    Usuario saveUsuario(Usuario usuario);

    
    Usuario updateUsuario(Usuario usuario);

    
    boolean deleteUsuarioById(Long id);

   
    Usuario getUsuarioById(Long id);

    
    List<Usuario> getAllUsuarios();

    
    List<Usuario> getUsuariosActivos();

	Optional<Usuario> buscarPorId(IdRequest idRequest);

   

}
