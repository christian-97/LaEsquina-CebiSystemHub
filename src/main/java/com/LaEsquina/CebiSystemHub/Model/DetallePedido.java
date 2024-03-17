package com.LaEsquina.CebiSystemHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_pedido")
@IdClass(DetallePedidoId.class)
public class DetallePedido {

    @Id
    @Column(name = "ID_Pedido")
    private Long idPedido;

    @Id
    @Column(name = "ID_Producto")
    private Long idProducto;

    @Column(name = "Cantidad")
    private int cantidad;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
   
    
}