package com.LaEsquina.CebiSystemHub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LaEsquina.CebiSystemHub.Model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByIdUsuario(Long idUsuario);

	List<Pedido> findAll();
}

