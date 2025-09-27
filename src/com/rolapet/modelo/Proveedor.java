package com.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa a un Proveedor en el sistema RolaPet.
 * 
 * Un Proveedor es una persona que puede ofrecer servicios o productos
 * a través del sistema. Esta clase define los comportamientos comunes
 * a todos los tipos de proveedores.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Proveedor extends Persona {
    
    /** Email del proveedor */
    private String email;
    
    /** Lista de items que ofrece el proveedor */
    private List<Item> items;
    
    /** Lista de publicaciones del proveedor */
    private List<Publicacion> publicaciones;
    
    /**
     * Constructor de la clase Proveedor.
     * 
     * @param cedula   Cédula de identificación
     * @param nombre   Nombre del proveedor
     * @param telefono Número de teléfono
     * @param password Contraseña de acceso
     * @param email    Email del proveedor
     */
    public Proveedor(String cedula, String nombre, String telefono, String password, String email) {
        super(cedula, nombre, telefono, password);
        this.email = email;
        this.items = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }
    
    /**
     * Obtiene el email del proveedor.
     * 
     * @return El email del proveedor
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece el email del proveedor.
     * 
     * @param email El email del proveedor
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene la lista de items del proveedor.
     * 
     * @return Lista de items del proveedor
     */
    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
    
    /**
     * Agrega un item a la lista del proveedor.
     * 
     * @param item El item a agregar
     * @return true si se agregó exitosamente, false si ya existe
     */
    public boolean agregarItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
            return true;
        }
        return false;
    }
    
    /**
     * Elimina un item de la lista del proveedor.
     * 
     * @param item El item a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarItem(Item item) {
        return items.remove(item);
    }
    
    /**
     * Obtiene la lista de publicaciones del proveedor.
     * 
     * @return Lista de publicaciones del proveedor
     */
    public List<Publicacion> getPublicaciones() {
        return new ArrayList<>(publicaciones);
    }
    
    /**
     * Agrega una publicación a la lista del proveedor.
     * 
     * @param publicacion La publicación a agregar
     * @return true si se agregó exitosamente, false si ya existe
     */
    public boolean agregarPublicacion(Publicacion publicacion) {
        if (publicacion != null && !publicaciones.contains(publicacion)) {
            publicaciones.add(publicacion);
            return true;
        }
        return false;
    }
    
    /**
     * Elimina una publicación de la lista del proveedor.
     * 
     * @param publicacion La publicación a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicaciones.remove(publicacion);
    }
    
    @Override
    public String toString() {
        return "Proveedor{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + getRol() + '\'' +
                ", items=" + items.size() +
                ", publicaciones=" + publicaciones.size() +
                '}';
    }
}
