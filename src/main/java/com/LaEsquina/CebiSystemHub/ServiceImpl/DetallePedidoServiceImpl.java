package com.LaEsquina.CebiSystemHub.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaEsquina.CebiSystemHub.Model.DetallePedido;
import com.LaEsquina.CebiSystemHub.Model.DetallePedidoId;
import com.LaEsquina.CebiSystemHub.Repository.DetallePedidoRepository;
import com.LaEsquina.CebiSystemHub.Service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
	
	@Autowired
    private DetallePedidoRepository detallePedidoRepository;

	@Override
    public List<DetallePedido> obtenerTodosDetallesPedido() {
        return detallePedidoRepository.findAll();
    }

	@Override
    public DetallePedido obtenerDetallePedidoPorId(Long idPedido, Long idProducto) {
        return detallePedidoRepository.findByIdPedidoAndIdProducto(idPedido, idProducto).orElse(null);
    }

    @Override
    public void guardarDetallePedido(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
    }

    @Override
    public void actualizarDetallePedido(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
    }

    @Override
    public void eliminarDetallePedido(Long idPedido, Long idProducto) {
        // Busca el detalle de pedido por su idPedido e idProducto
        DetallePedidoId detallePedidoId = new DetallePedidoId(idPedido, idProducto);
        DetallePedido detallePedido = detallePedidoRepository.findById(detallePedidoId)
                                        .orElseThrow(() -> new IllegalArgumentException("No se encontró el detalle de pedido"));

        
        detallePedidoRepository.delete(detallePedido);
    }

}
