package com.LaEsquina.CebiSystemHub.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LaEsquina.CebiSystemHub.Model.DetallePedido;
import com.LaEsquina.CebiSystemHub.Service.DetallePedidoService;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/listar/{idPedido}")
    public ResponseEntity<List<DetallePedido>> obtenerDetallesPedidoPorIdPedido(@PathVariable Long idPedido) {
        List<DetallePedido> detallesPedido = detallePedidoService.obtenerDetallesPedidoPorIdPedido(idPedido);
        return ResponseEntity.ok(detallesPedido);
    }

    @PostMapping("/guardar/{idPedido}")
    public ResponseEntity<?> agregarDetallePedido(@PathVariable Long idPedido, @RequestBody List<DetallePedido> detallesPedido) {
        for (DetallePedido detallePedido : detallesPedido) {
            detallePedido.setIdPedido(idPedido);
            detallePedidoService.guardarDetallePedido(detallePedido);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{idPedido}/{idDetalle}")
    public ResponseEntity<?> eliminarDetallePedido(@PathVariable Long idPedido, @PathVariable Long idDetalle) {
        detallePedidoService.eliminarDetallePedido(idPedido, idDetalle);
        return ResponseEntity.ok().build();
    }
}
