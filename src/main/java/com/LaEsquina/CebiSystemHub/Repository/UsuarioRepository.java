package com.LaEsquina.CebiSystemHub.Repository;

import com.LaEsquina.CebiSystemHub.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método personalizado para encontrar todos los usuarios activos
    List<Usuario> findAllByActivoTrue();
}
