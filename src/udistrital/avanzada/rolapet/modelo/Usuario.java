package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un Usuario en el sistema RolaPet.
 * 
 * Un Usuario es una persona que puede registrarse en el sistema,
 * gestionar vehículos eléctricos y mantener una lista de amigos.
 * Esta clase extiende de Persona y agrega funcionalidades específicas
 * para usuarios regulares del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Usuario extends Persona {
    
    /** Dirección de correo electrónico del usuario */
    private String email;
    
    /** Lista de vehículos que posee el usuario */
    private List<Vehiculo> vehiculos;
    
    /** Lista de amigos del usuario (otros usuarios) */
    private List<Usuario> amigos;
    
    /**
     * Constructor de la clase Usuario.
     * 
     * Este constructor crea un nuevo usuario con la información básica
     * y inicializa las listas de vehículos y amigos como listas vacías.
     * 
     * @param cedula   Cédula de identificación del usuario
     * @param nombre   Nombre completo del usuario
     * @param telefono Número de teléfono del usuario
     * @param password Contraseña de acceso del usuario
     * @param email    Dirección de correo electrónico del usuario
     */
    public Usuario(String cedula, String nombre, String telefono, String password, String email) {
        super(cedula, nombre, telefono, password);
        this.email = email;
        this.vehiculos = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    
    /**
     * Obtiene la dirección de correo electrónico del usuario.
     * 
     * Este método devuelve el email registrado del usuario,
     * que se utiliza para autenticación y comunicación.
     * 
     * @return La dirección de email del usuario
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece la dirección de correo electrónico del usuario.
     * 
     * Este método permite actualizar el email del usuario
     * en caso de cambios o correcciones.
     * 
     * @param email La nueva dirección de email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene el rol específico del usuario.
     * 
     * Este método identifica que esta persona es un Usuario
     * del sistema, diferenciándolo de Administradores y Proveedores.
     * 
     * @return El rol "Usuario" para esta persona
     */
    @Override
    public String getRol() {
        return "Usuario";
    }
    
    /**
     * Obtiene la lista de vehículos del usuario.
     * 
     * Este método devuelve una copia de la lista de vehículos
     * para evitar modificaciones externas no controladas.
     * 
     * @return Lista de vehículos que posee el usuario
     */
    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos);
    }
    
    /**
     * Agrega un vehículo a la lista del usuario.
     * 
     * Este método permite al usuario agregar un nuevo vehículo
     * a su colección personal, verificando que no esté duplicado.
     * 
     * @param vehiculo El vehículo a agregar a la lista del usuario
     * @return true si el vehículo se agregó exitosamente, false si ya existía
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
     * Este método permite al usuario remover un vehículo
     * de su colección personal.
     * 
     * @param vehiculo El vehículo a eliminar de la lista del usuario
     * @return true si el vehículo se eliminó exitosamente, false si no existía
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }
    
    /**
     * Obtiene la lista de amigos del usuario.
     * 
     * Este método devuelve una copia de la lista de amigos
     * para evitar modificaciones externas no controladas.
     * 
     * @return Lista de amigos del usuario
     */
    public List<Usuario> getAmigos() {
        return new ArrayList<>(amigos);
    }
    
    /**
     * Agrega un amigo a la lista del usuario.
     * 
     * Este método permite al usuario agregar otro usuario como amigo,
     * verificando que no sea el mismo usuario y que no esté duplicado.
     * 
     * @param amigo El usuario a agregar como amigo
     * @return true si el amigo se agregó exitosamente, false si ya era amigo o es el mismo usuario
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
     * Este método permite al usuario remover otro usuario
     * de su lista de amigos.
     * 
     * @param amigo El usuario a eliminar de la lista de amigos
     * @return true si el amigo se eliminó exitosamente, false si no era amigo
     */
    public boolean eliminarAmigo(Usuario amigo) {
        return amigos.remove(amigo);
    }
    
    /**
     * Verifica si un usuario es amigo del usuario actual.
     * 
     * Este método permite verificar si un usuario específico
     * está en la lista de amigos del usuario actual.
     * 
     * @param usuario El usuario a verificar si es amigo
     * @return true si el usuario es amigo, false en caso contrario
     */
    public boolean esAmigo(Usuario usuario) {
        return amigos.contains(usuario);
    }
    
    /**
     * Genera una representación en texto del usuario.
     * 
     * Este método crea una cadena de texto que contiene la información
     * completa del usuario, incluyendo datos personales y estadísticas
     * de vehículos y amigos.
     * 
     * @return Una cadena con la información completa del usuario
     */
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