package com.rolapet.modelo;

/**
 * Clase abstracta que representa un Item en el sistema RolaPet.
 * 
 * Un Item puede ser un Servicio o un Producto que ofrece un proveedor.
 * Esta clase define los atributos y comportamientos comunes a todos
 * los tipos de items del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Item {
    
    /** Identificador único del item */
    private String id;
    
    /** Nombre del item */
    private String nombre;
    
    /** Descripción del item */
    private String descripcion;
    
    /**
     * Constructor de la clase Item.
     * 
     * @param id          Identificador único del item
     * @param nombre      Nombre del item
     * @param descripcion Descripción del item
     */
    public Item(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene el identificador del item.
     * 
     * @return El identificador del item
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el identificador del item.
     * 
     * @param id El identificador del item
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el nombre del item.
     * 
     * @return El nombre del item
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del item.
     * 
     * @param nombre El nombre del item
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la descripción del item.
     * 
     * @return La descripción del item
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripción del item.
     * 
     * @param descripcion La descripción del item
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Método abstracto que debe ser implementado por las clases hijas
     * para obtener el tipo específico de item.
     * 
     * @return El tipo de item
     */
    public abstract String getTipo();
    
    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + getTipo() + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id != null ? id.equals(item.id) : item.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
