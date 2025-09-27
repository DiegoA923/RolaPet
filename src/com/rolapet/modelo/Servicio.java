package com.rolapet.modelo;

/**
 * Clase que representa un Servicio en el sistema RolaPet.
 * 
 * Un Servicio es un tipo de Item que ofrece un proveedor,
 * como mantenimiento, reparación, limpieza, etc.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Servicio extends Item {
    
    /**
     * Constructor de la clase Servicio.
     * 
     * @param id          Identificador único del servicio
     * @param nombre       Nombre del servicio
     * @param descripcion Descripción del servicio
     */
    public Servicio(String id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }
    
    /**
     * Obtiene el tipo de item.
     * 
     * @return El tipo de item
     */
    @Override
    public String getTipo() {
        return "Servicio";
    }
    
    @Override
    public String toString() {
        return "Servicio{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }
}
