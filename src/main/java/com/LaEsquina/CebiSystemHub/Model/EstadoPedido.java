package com.LaEsquina.CebiSystemHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_pedido_7")
public class EstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estado_Pedido")
    private Long idEstadoPedido;

    @Column(name = "Estado")
    private String estado;

    // Constructor, getters y setters

    public EstadoPedido() {
    }

    public EstadoPedido(String estado) {
        this.estado = estado;
    }

    public Long getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Long idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
