package udistrital.avanzada.rolapet.modelo;

/**
 * Representa un Proveedor de Servicios dentro del sistema RolaPet.
 * <p>
 * Un Proveedor de Servicios ofrece servicios al sistema, como limpieza,
 * mantenimiento o transporte. Esta clase hereda de {@link Proveedor} 
 * y define su rol específico como "Proveedor de Servicios".
 * </p>
 * 
 * @author Diego
 * @version 1.0
 * @date 23/09/2025
 */
public class ProveedorServicio extends Proveedor {

    /**
     * Crea un nuevo Proveedor de Servicios con la información básica.
     * 
     * @param cedula   La cédula del proveedor
     * @param nombre   El nombre del proveedor
     * @param apellido El apellido del proveedor
     * @param telefono El número de teléfono del proveedor
     * @param correo   El correo electrónico del proveedor
     * @param password La contraseña del proveedor
     */
    public ProveedorServicio(int cedula, String nombre, String apellido, int telefono, String correo, String password) {
        super(cedula, nombre, apellido, telefono, correo, password);
    }
    
    /**
     * Devuelve el rol específico de este proveedor.
     * 
     * @return Una cadena indicando que es "Proveedor de Servicios".
     */
    @Override
    public String getRol() {
        return "Proveedor de Servicios";
    }
}
