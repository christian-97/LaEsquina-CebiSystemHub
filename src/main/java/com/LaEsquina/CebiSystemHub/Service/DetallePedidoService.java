package com.LaEsquina.CebiSystemHub.Service;

import java.util.List;

import com.LaEsquina.CebiSystemHub.Model.DetallePedido;

public interface DetallePedidoService {
	List<DetallePedido> obtenerDetallesPedidoPorIdPedido(Long idPedido);
    DetallePedido obtenerDetallePedidoPorId(Long idPedido, Long idProducto);
    void guardarDetallePedido(DetallePedido detallePedido);
    void actualizarDetallePedido(DetallePedido detallePedido);
    void eliminarDetallePedido(Long idPedido, Long idProducto);
}
