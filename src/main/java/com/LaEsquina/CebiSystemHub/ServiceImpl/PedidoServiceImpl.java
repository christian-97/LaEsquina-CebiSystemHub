package com.LaEsquina.CebiSystemHub.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.LaEsquina.CebiSystemHub.Model.Pedido;
import com.LaEsquina.CebiSystemHub.Repository.PedidoRepository;
import com.LaEsquina.CebiSystemHub.Service.PedidoService;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
    private PedidoRepository pedidoRepository;

	public List<Pedido> obtenerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void guardarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void actualizarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
    
    
    @Override
    public List<Pedido> findPedidosByIdUsuario(Long idUsuario) {
        return pedidoRepository.findByIdUsuario(idUsuario);
    }
    
    
    

}
