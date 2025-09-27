package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa un Servicio en el sistema RolaPet.
 * 
 * Un Servicio es un tipo de Item que ofrece un proveedor,
 * como mantenimiento, reparación, limpieza, consultoría, etc.
 * Los servicios son actividades que el proveedor realiza
 * para los usuarios del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Servicio extends Item {
    
    /**
     * Constructor de la clase Servicio.
     * 
     * Este constructor crea un nuevo servicio con la información
     * básica requerida para identificarlo en el catálogo del proveedor.
     * 
     * @param id          Identificador único del servicio en el sistema
     * @param nombre       Nombre comercial del servicio
     * @param descripcion Descripción detallada del servicio
     */
    public Servicio(String id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }
    
    /**
     * Obtiene el tipo específico de item.
     * 
     * Este método identifica que este item es un Servicio,
     * diferenciándolo de los productos físicos.
     * 
     * @return El tipo "Servicio" para este item
     */
    @Override
    public String getTipo() {
        return "Servicio";
    }
    
    /**
     * Genera una representación en texto del servicio.
     * 
     * Este método crea una cadena de texto que contiene la información
     * específica del servicio, incluyendo todos sus datos.
     * 
     * @return Una cadena con la información completa del servicio
     */
    @Override
    public String toString() {
        return "Servicio{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }
}
