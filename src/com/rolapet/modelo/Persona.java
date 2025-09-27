package com.rolapet.modelo;

/**
 * Clase abstracta que representa a una persona dentro del sistema RolaPet.
 * 
 * Esta clase define los atributos y comportamientos comunes a todos los tipos
 * de personas en el sistema (Usuario, Administrador, Proveedor), siguiendo
 * el principio de sustitución de Liskov.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Persona {
    
    /** Cédula de identificación única de la persona */
    protected String cedula;
    
    /** Nombre de la persona */
    protected String nombre;
    
    /** Número de teléfono de contacto */
    protected String telefono;
    
    /** Contraseña para autenticación en el sistema */
    protected String password;
    
    /**
     * Constructor de la clase Persona.
     * 
     * @param cedula   Cédula de identificación
     * @param nombre   Nombre de la persona
     * @param telefono Número de teléfono
     * @param password Contraseña de acceso
     */
    public Persona(String cedula, String nombre, String telefono, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.password = password;
    }
    
    /**
     * Obtiene la cédula de la persona.
     * 
     * @return La cédula de la persona
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Establece la cédula de la persona.
     * 
     * @param cedula La cédula de la persona
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Obtiene el nombre de la persona.
     * 
     * @return El nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre El nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el teléfono de la persona.
     * 
     * @return El teléfono de la persona
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Establece el teléfono de la persona.
     * 
     * @param telefono El teléfono de la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Obtiene la contraseña de la persona.
     * 
     * @return La contraseña de la persona
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Establece la contraseña de la persona.
     * 
     * @param password La contraseña de la persona
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Método abstracto que debe ser implementado por las clases hijas
     * para obtener el rol específico de cada tipo de persona.
     * 
     * @return El rol de la persona en el sistema
     */
    public abstract String getRol();
    
    /**
     * Método abstracto que debe ser implementado por las clases hijas
     * para obtener el email de la persona.
     * 
     * @return El email de la persona
     */
    public abstract String getEmail();
    
    @Override
    public String toString() {
        return "Persona{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol='" + getRol() + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return cedula != null ? cedula.equals(persona.cedula) : persona.cedula == null;
    }
    
    @Override
    public int hashCode() {
        return cedula != null ? cedula.hashCode() : 0;
    }
}
