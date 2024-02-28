package com.LaEsquina.CebiSystemHub.Repository;

import com.LaEsquina.CebiSystemHub.Model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
    // Aquí puedes agregar métodos personalizados para consultar la base de datos si es necesario
}
