package com.LaEsquina.CebiSystemHub.Model;

import java.io.Serializable;

public class DetallePedidoId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idPedido;

    private Long idProducto;
    
    public DetallePedidoId() {
    }

    

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

	public DetallePedidoId(Long idPedido, Long idProducto) {
		super();
		this.idPedido = idPedido;
		this.idProducto = idProducto;
	}
    
	
	
    

}
