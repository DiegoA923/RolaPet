package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta que representa un Item en el sistema RolaPet.
 * 
 * Un Item puede ser un Servicio o un Producto que ofrece un proveedor.
 * Esta clase define los atributos y comportamientos comunes a todos
 * los tipos de items del sistema, permitiendo la gestión de catálogos
 * de proveedores.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Item {
    
    /** Identificador único del item en el sistema */
    private String id;
    
    /** Nombre comercial del item */
    private String nombre;
    
    /** Descripción detallada del item */
    private String descripcion;
    
    /**
     * Constructor de la clase Item.
     * 
     * Este constructor inicializa un nuevo item con los datos
     * básicos proporcionados. Es llamado por las clases hijas
     * para establecer la información fundamental de cualquier item.
     * 
     * @param id          Identificador único del item en el sistema
     * @param nombre       Nombre comercial del item
     * @param descripcion Descripción detallada del item
     */
    public Item(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene el identificador único del item.
     * 
     * Este método devuelve el ID que identifica únicamente
     * a este item en el sistema.
     * 
     * @return El identificador único del item
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el identificador único del item.
     * 
     * Este método permite modificar el ID del item,
     * útil para correcciones o reorganización de datos.
     * 
     * @param id El nuevo identificador único del item
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el nombre comercial del item.
     * 
     * Este método devuelve el nombre con el que se comercializa
     * el item en el sistema.
     * 
     * @return El nombre comercial del item
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre comercial del item.
     * 
     * Este método permite actualizar el nombre del item
     * en caso de correcciones o cambios en la comercialización.
     * 
     * @param nombre El nuevo nombre comercial del item
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la descripción detallada del item.
     * 
     * Este método devuelve la descripción que explica
     * las características y detalles del item.
     * 
     * @return La descripción detallada del item
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripción detallada del item.
     * 
     * Este método permite actualizar la descripción del item
     * para proporcionar información más detallada o corregir errores.
     * 
     * @param descripcion La nueva descripción detallada del item
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Método abstracto para obtener el tipo específico de item.
     * 
     * Este método debe ser implementado por cada clase hija para
     * devolver el tipo específico de item (Servicio, Producto).
     * Permite categorizar y diferenciar los tipos de items.
     * 
     * @return El tipo específico de item
     */
    public abstract String getTipo();
    
    /**
     * Genera una representación en texto del item.
     * 
     * Este método crea una cadena de texto que contiene la información
     * completa del item, incluyendo ID, nombre, descripción y tipo.
     * Es útil para mostrar información del item en la interfaz.
     * 
     * @return Una cadena con la información completa del item
     */
    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + getTipo() + '\'' +
                '}';
    }
    
    /**
     * Compara si dos items son iguales basándose en su ID.
     * 
     * Este método permite determinar si dos objetos Item representan
     * al mismo item comparando sus identificadores únicos.
     * 
     * @param obj El objeto a comparar
     * @return true si los items tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id != null ? id.equals(item.id) : item.id == null;
    }
    
    /**
     * Genera un código hash basado en el ID del item.
     * 
     * Este método es utilizado por las estructuras de datos como HashMap
     * para organizar y buscar objetos Item de manera eficiente.
     * 
     * @return El código hash del item basado en su ID
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
