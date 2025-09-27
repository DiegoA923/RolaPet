package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa un Producto en el sistema RolaPet.
 * 
 * Un Producto es un tipo de Item que ofrece un proveedor,
 * como repuestos, accesorios, baterías, cascos, etc.
 * Los productos son objetos físicos que el proveedor
 * puede vender a los usuarios del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Producto extends Item {
    
    /**
     * Constructor de la clase Producto.
     * 
     * Este constructor crea un nuevo producto con la información
     * básica requerida para identificarlo en el catálogo del proveedor.
     * 
     * @param id          Identificador único del producto en el sistema
     * @param nombre       Nombre comercial del producto
     * @param descripcion Descripción detallada del producto
     */
    public Producto(String id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }
    
    /**
     * Obtiene el tipo específico de item.
     * 
     * Este método identifica que este item es un Producto,
     * diferenciándolo de los servicios.
     * 
     * @return El tipo "Producto" para este item
     */
    @Override
    public String getTipo() {
        return "Producto";
    }
    
    /**
     * Genera una representación en texto del producto.
     * 
     * Este método crea una cadena de texto que contiene la información
     * específica del producto, incluyendo todos sus datos.
     * 
     * @return Una cadena con la información completa del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }
}
