package com.rolapet.modelo;

/**
 * Clase que representa un Producto en el sistema RolaPet.
 * 
 * Un Producto es un tipo de Item que ofrece un proveedor,
 * como repuestos, accesorios, baterías, etc.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Producto extends Item {
    
    /**
     * Constructor de la clase Producto.
     * 
     * @param id          Identificador único del producto
     * @param nombre       Nombre del producto
     * @param descripcion Descripción del producto
     */
    public Producto(String id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }
    
    /**
     * Obtiene el tipo de item.
     * 
     * @return El tipo de item
     */
    @Override
    public String getTipo() {
        return "Producto";
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }
}
