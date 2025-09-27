package com.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un Usuario en el sistema RolaPet.
 * 
 * Un Usuario es una persona que puede registrarse en el sistema,
 * gestionar vehículos y mantener una lista de amigos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Usuario extends Persona {
    
    /** Email del usuario */
    private String email;
    
    /** Lista de vehículos que posee el usuario */
    private List<Vehiculo> vehiculos;
    
    /** Lista de amigos del usuario */
    private List<Usuario> amigos;
    
    /**
     * Constructor de la clase Usuario.
     * 
     * @param cedula   Cédula de identificación
     * @param nombre   Nombre del usuario
     * @param telefono Número de teléfono
     * @param password Contraseña de acceso
     * @param email    Email del usuario
     */
    public Usuario(String cedula, String nombre, String telefono, String password, String email) {
        super(cedula, nombre, telefono, password);
        this.email = email;
        this.vehiculos = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    
    /**
     * Obtiene el email del usuario.
     * 
     * @return El email del usuario
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece el email del usuario.
     * 
     * @param email El email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene el rol del usuario.
     * 
     * @return El rol del usuario
     */
    @Override
    public String getRol() {
        return "Usuario";
    }
    
    /**
     * Obtiene la lista de vehículos del usuario.
     * 
     * @return Lista de vehículos del usuario
     */
    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos);
    }
    
    /**
     * Agrega un vehículo a la lista del usuario.
     * 
     * @param vehiculo El vehículo a agregar
     * @return true si se agregó exitosamente, false si ya existe
     */
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            return true;
        }
        return false;
    }
    
    /**
     * Elimina un vehículo de la lista del usuario.
     * 
     * @param vehiculo El vehículo a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }
    
    /**
     * Obtiene la lista de amigos del usuario.
     * 
     * @return Lista de amigos del usuario
     */
    public List<Usuario> getAmigos() {
        return new ArrayList<>(amigos);
    }
    
    /**
     * Agrega un amigo a la lista del usuario.
     * 
     * @param amigo El usuario a agregar como amigo
     * @return true si se agregó exitosamente, false si ya es amigo o es el mismo usuario
     */
    public boolean agregarAmigo(Usuario amigo) {
        if (amigo != null && !amigo.equals(this) && !amigos.contains(amigo)) {
            amigos.add(amigo);
            return true;
        }
        return false;
    }
    
    /**
     * Elimina un amigo de la lista del usuario.
     * 
     * @param amigo El usuario a eliminar de la lista de amigos
     * @return true si se eliminó exitosamente, false si no era amigo
     */
    public boolean eliminarAmigo(Usuario amigo) {
        return amigos.remove(amigo);
    }
    
    /**
     * Verifica si un usuario es amigo.
     * 
     * @param usuario El usuario a verificar
     * @return true si es amigo, false en caso contrario
     */
    public boolean esAmigo(Usuario usuario) {
        return amigos.contains(usuario);
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", vehiculos=" + vehiculos.size() +
                ", amigos=" + amigos.size() +
                '}';
    }
}
