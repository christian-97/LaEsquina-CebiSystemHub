package com.LaEsquina.CebiSystemHub.Repository;

import com.LaEsquina.CebiSystemHub.Model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}
