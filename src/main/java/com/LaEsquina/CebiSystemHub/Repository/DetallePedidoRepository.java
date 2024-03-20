package com.LaEsquina.CebiSystemHub.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.LaEsquina.CebiSystemHub.Model.DetallePedido;
import com.LaEsquina.CebiSystemHub.Model.DetallePedidoId;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoId> {

    Optional<DetallePedido> findByIdPedidoAndIdProducto(Long idPedido, Long idProducto);
    
    List<DetallePedido> findByIdPedido(Long idPedido);
}