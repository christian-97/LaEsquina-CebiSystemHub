package com.LaEsquina.CebiSystemHub.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name = "plato_13")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private Long id;

    @Column(name = "Product_name")
    private String productName;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria")
    private Categoria categoria;

    @Column(name = "Disponibilidad")
    private boolean disponibilidad;

    @Column(name = "Imagen")
    private byte[] imagen;

    // Constructor, getters y setters

    public Plato() {
    }

    public Plato(String productName, String descripcion, double precio, Categoria categoria, boolean disponibilidad, byte[] imagen) {
        this.productName = productName;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
