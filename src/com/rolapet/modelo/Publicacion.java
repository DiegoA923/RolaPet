package com.rolapet.modelo;

/**
 * Clase abstracta que representa una Publicación en el sistema RolaPet.
 * 
 * Una Publicación puede ser un Evento o una Promoción que crea un proveedor
 * para promocionar sus servicios o productos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Publicacion {
    
    /** Identificador único de la publicación */
    private String id;
    
    /** Título de la publicación */
    private String titulo;
    
    /** Descripción de la publicación */
    private String descripcion;
    
    /** Fecha de creación de la publicación */
    private String fechaCreacion;
    
    /**
     * Constructor de la clase Publicacion.
     * 
     * @param id            Identificador único de la publicación
     * @param titulo         Título de la publicación
     * @param descripcion   Descripción de la publicación
     * @param fechaCreacion Fecha de creación
     */
    public Publicacion(String id, String titulo, String descripcion, String fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Obtiene el identificador de la publicación.
     * 
     * @return El identificador de la publicación
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el identificador de la publicación.
     * 
     * @param id El identificador de la publicación
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el título de la publicación.
     * 
     * @return El título de la publicación
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Establece el título de la publicación.
     * 
     * @param titulo El título de la publicación
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Obtiene la descripción de la publicación.
     * 
     * @return La descripción de la publicación
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripción de la publicación.
     * 
     * @param descripcion La descripción de la publicación
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene la fecha de creación de la publicación.
     * 
     * @return La fecha de creación
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    /**
     * Establece la fecha de creación de la publicación.
     * 
     * @param fechaCreacion La fecha de creación
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Método abstracto que debe ser implementado por las clases hijas
     * para obtener el tipo específico de publicación.
     * 
     * @return El tipo de publicación
     */
    public abstract String getTipo();
    
    @Override
    public String toString() {
        return "Publicacion{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", tipo='" + getTipo() + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Publicacion that = (Publicacion) obj;
        return id != null ? id.equals(that.id) : that.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
