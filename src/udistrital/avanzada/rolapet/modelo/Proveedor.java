package udistrital.avanzada.rolapet.modelo;

/**
 * Representa un Proveedor dentro del sistema RolaPet.
 * <p>
 * Un Proveedor es una persona o entidad que suministra productos o servicios
 * al sistema. Esta clase hereda de {@link Persona} y define el rol específico
 * de "Proveedor".
 * </p>
 * 
 * @author Diego
 * @version 1.0
 * @date 23/09/2025
 */
public abstract class Proveedor extends Persona {

    /**
     * Crea un nuevo Proveedor con la información básica.
     * 
     * @param cedula   La cédula del proveedor
     * @param nombre   El nombre del proveedor
     * @param apellido El apellido del proveedor
     * @param telefono El número de teléfono del proveedor
     * @param correo   El correo electrónico del proveedor
     * @param password La contraseña del proveedor
     */
    public Proveedor(int cedula, String nombre, String apellido, int telefono, String correo, String password) {
        super(cedula, nombre, apellido, telefono, correo, password);
    }
    
    
}
