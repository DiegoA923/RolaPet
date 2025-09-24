package udistrital.avanzada.rolapet.modelo;

/**
 * Representa un Usuario dentro del sistema RolaPet.
 * <p>
 * Un Usuario es una persona que puede registrarse, autenticarse y
 * consultar o actualizar su perfil dentro del sistema. Esta clase
 * hereda de {@link Persona} y define el rol específico de "Usuario".
 * </p>
 * 
 * @author Diego
 * @version 1.0
 * @date 23/09/2025
 */
public class Usuario extends Persona {

    /**
     * Crea un nuevo Usuario con la información básica.
     * 
     * @param cedula   La cédula del usuario
     * @param nombre   El nombre del usuario
     * @param apellido El apellido del usuario
     * @param telefono El número de teléfono del usuario
     * @param correo   El correo electrónico del usuario
     * @param password La contraseña del usuario
     */
    public Usuario(int cedula, String nombre, String apellido, int telefono, String correo, String password) {
        super(cedula, nombre, apellido, telefono, correo, password);
    }
    
    /**
     * Devuelve el rol de esta persona.
     * 
     * @return Una cadena indicando el rol, en este caso "Usuario".
     */
    @Override
    public String getRol() {
        return "Usuario";
    }
}


