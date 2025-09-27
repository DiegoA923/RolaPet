package com.rolapet.modelo;

/**
 * Clase que representa a un Administrador en el sistema RolaPet.
 * 
 * Un Administrador es una persona con privilegios especiales para
 * gestionar el sistema, usuarios, proveedores y vehículos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Administrador extends Persona {
    
    /** Email del administrador */
    private String email;
    
    /**
     * Constructor de la clase Administrador.
     * 
     * @param cedula   Cédula de identificación
     * @param nombre   Nombre del administrador
     * @param telefono Número de teléfono
     * @param password Contraseña de acceso
     * @param email    Email del administrador
     */
    public Administrador(String cedula, String nombre, String telefono, String password, String email) {
        super(cedula, nombre, telefono, password);
        this.email = email;
    }
    
    /**
     * Obtiene el email del administrador.
     * 
     * @return El email del administrador
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece el email del administrador.
     * 
     * @param email El email del administrador
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene el rol del administrador.
     * 
     * @return El rol del administrador
     */
    @Override
    public String getRol() {
        return "Administrador";
    }
    
    @Override
    public String toString() {
        return "Administrador{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
