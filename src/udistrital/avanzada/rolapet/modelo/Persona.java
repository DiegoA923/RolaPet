package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * 
 * La clase Persona.java es la base para los diferentes tipos de usuarios
 * (Usuarios, Proveedores, Administradores). Contiene la información 
 * común a todos, como datos personales y credenciales de acceso.
 * 
 * @author Diego
 * @version 1.0
 * @date 23/09/2025
 */
public abstract class Persona {

    /** Documento de identidad único de la persona */
    private int cedula;

    private String nombre;

    private String apellido;

    private int telefono;

    private String correo;

    /** Contraseña para acceder al sistema */
    private String password;

    /**
     * Constructor de la clase Persona.
     * 
     * @param cedula    Documento de identidad
     * @param nombre    Nombre de la persona
     * @param apellido  Apellido de la persona
     * @param telefono  Número de contacto
     * @param correo    Correo electrónico
     * @param password  Contraseña de acceso
     */
    
    public Persona(int cedula, String nombre, String apellido, int telefono, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devuelve una representación en texto de la persona (sin mostrar la contraseña).
     * 
     * @return Cadena con nombre completo, cédula, teléfono y correo.
     */
    
    @Override
    public String toString() {
        return nombre + " " + apellido + " | Cédula: " + cedula 
               + " | Tel: " + telefono + " | Correo: " + correo;
    }
}

