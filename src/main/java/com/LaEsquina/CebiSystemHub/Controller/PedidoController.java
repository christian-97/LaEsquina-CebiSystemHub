package com.LaEsquina.CebiSystemHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LaEsquina.CebiSystemHub.Model.Pedido;
import com.LaEsquina.CebiSystemHub.Model.PedidoIdRequest;
import com.LaEsquina.CebiSystemHub.Model.PedidoUsuarioRequest;
import com.LaEsquina.CebiSystemHub.Service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    
    @GetMapping("/todos")
    public ResponseEntity<List<Pedido>> obtenerTodosPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerTodosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    
    @PostMapping("/buscar")
    public ResponseEntity<Pedido> buscarPedidoPorId(@RequestBody PedidoIdRequest pedidoIdRequest) {
        Long idPedido = pedidoIdRequest.getIdPedido();
        Pedido pedido = pedidoService.obtenerPedidoPorId(idPedido);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setIdPedido(id);
        pedidoService.actualizarPedido(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>("Pedido eliminado correctamente", HttpStatus.OK);
    }
    
    
    @GetMapping("/pedido-usuario/{idUsuario}")
    public ResponseEntity<List<Pedido>> getPedidosByIdUsuario(@PathVariable Long idUsuario) {
        List<Pedido> pedidos = pedidoService.findPedidosByIdUsuario(idUsuario);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

}
