package udistrital.avanzada.rolapet.modelo;

/**
 * @author diego
 * @version 1.0
 * @date 23/09/2025
 * 
 * Representa un Administrador dentro del sistema RolaPet, 
 * encargado de gestionar usuarios, proveedores y otras operaciones administrativas.
 * 
 */
public class Administrador extends Persona {

    public Administrador(int cedula, String nombre, String apellido, int telefono, String correo, String password) {
        super(cedula, nombre, apellido, telefono, correo, password);
    }
    
    @Override
    public String getRol(){
        return "Administrador";
    }
}

