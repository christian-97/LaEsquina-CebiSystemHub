package com.LaEsquina.CebiSystemHub.Service;

import java.util.List;

import com.LaEsquina.CebiSystemHub.Model.Pedido;

public interface PedidoService {
    
    Pedido obtenerPedidoPorId(Long id);
    void guardarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
	List<Pedido> obtenerTodosPedidos();
	List<Pedido> findPedidosByIdUsuario(Long idUsuario);
}
