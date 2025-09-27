package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa a un Administrador en el sistema RolaPet.
 * 
 * Un Administrador es una persona con privilegios especiales para
 * gestionar el sistema, usuarios, proveedores y vehículos. Tiene acceso
 * a funcionalidades administrativas que no están disponibles para
 * usuarios regulares o proveedores.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Administrador extends Persona {
    
    /** Dirección de correo electrónico del administrador */
    private String email;
    
    /**
     * Constructor de la clase Administrador.
     * 
     * Este constructor crea un nuevo administrador con la información
     * básica requerida para acceder al sistema con privilegios administrativos.
     * 
     * @param cedula   Cédula de identificación del administrador
     * @param nombre   Nombre completo del administrador
     * @param telefono Número de teléfono del administrador
     * @param password Contraseña de acceso del administrador
     * @param email    Dirección de correo electrónico del administrador
     */
    public Administrador(String cedula, String nombre, String telefono, String password, String email) {
        super(cedula, nombre, telefono, password);
        this.email = email;
    }
    
    /**
     * Obtiene la dirección de correo electrónico del administrador.
     * 
     * Este método devuelve el email registrado del administrador,
     * que se utiliza para comunicación y notificaciones del sistema.
     * 
     * @return La dirección de email del administrador
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece la dirección de correo electrónico del administrador.
     * 
     * Este método permite actualizar el email del administrador
     * en caso de cambios o correcciones.
     * 
     * @param email La nueva dirección de email del administrador
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene el rol específico del administrador.
     * 
     * Este método identifica que esta persona es un Administrador
     * del sistema, lo que le otorga privilegios especiales de gestión.
     * 
     * @return El rol "Administrador" para esta persona
     */
    @Override
    public String getRol() {
        return "Administrador";
    }
    
    /**
     * Genera una representación en texto del administrador.
     * 
     * Este método crea una cadena de texto que contiene la información
     * completa del administrador, incluyendo datos personales y rol.
     * 
     * @return Una cadena con la información completa del administrador
     */
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