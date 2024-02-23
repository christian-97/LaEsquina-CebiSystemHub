package com.LaEsquina.CebiSystemHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol_2") // Asegura que el nombre de la tabla coincida con el nombre real en tu BBDD
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Rol") // Usa el nombre exacto de la columna en tu base de datos
    private Long id;

    @Column(name = "Tipo_Rol") // Asume que tienes una columna 'descripcion'. Ajusta según sea necesario.
    private String descripcion;

    // Constructor vacío necesario para JPA
    public Rol() {
    }

    // Constructor con parámetros
    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método toString opcional para depuración y logs
    @Override
    public String toString() {
        return "Rol{" +
               "id=" + id +
               ", descripcion='" + descripcion + '\'' +
               '}';
    }
}

