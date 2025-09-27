package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta que representa una Publicación en el sistema RolaPet.
 * 
 * Una Publicación puede ser un Evento o una Promoción que crea un proveedor
 * para promocionar sus servicios o productos. Permite a los proveedores
 * comunicar ofertas especiales, eventos, descuentos y novedades
 * a los usuarios del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Publicacion {
    
    /** Identificador único de la publicación en el sistema */
    private String id;
    
    /** Título descriptivo de la publicación */
    private String titulo;
    
    /** Descripción detallada del contenido de la publicación */
    private String descripcion;
    
    /** Fecha de creación de la publicación en formato texto */
    private String fechaCreacion;
    
    /**
     * Constructor de la clase Publicacion.
     * 
     * Este constructor inicializa una nueva publicación con los datos
     * básicos proporcionados. Es llamado por las clases hijas para
     * establecer la información fundamental de cualquier publicación.
     * 
     * @param id            Identificador único de la publicación en el sistema
     * @param titulo         Título descriptivo de la publicación
     * @param descripcion   Descripción detallada del contenido
     * @param fechaCreacion Fecha de creación de la publicación
     */
    public Publicacion(String id, String titulo, String descripcion, String fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Obtiene el identificador único de la publicación.
     * 
     * Este método devuelve el ID que identifica únicamente
     * a esta publicación en el sistema.
     * 
     * @return El identificador único de la publicación
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el identificador único de la publicación.
     * 
     * Este método permite modificar el ID de la publicación,
     * útil para correcciones o reorganización de datos.
     * 
     * @param id El nuevo identificador único de la publicación
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el título descriptivo de la publicación.
     * 
     * Este método devuelve el título que describe brevemente
     * el contenido de la publicación.
     * 
     * @return El título descriptivo de la publicación
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Establece el título descriptivo de la publicación.
     * 
     * Este método permite actualizar el título de la publicación
     * para hacerlo más descriptivo o atractivo.
     * 
     * @param titulo El nuevo título descriptivo de la publicación
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Obtiene la descripción detallada de la publicación.
     * 
     * Este método devuelve la descripción que explica
     * el contenido completo de la publicación.
     * 
     * @return La descripción detallada de la publicación
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripción detallada de la publicación.
     * 
     * Este método permite actualizar la descripción de la publicación
     * para proporcionar más información o corregir detalles.
     * 
     * @param descripcion La nueva descripción detallada de la publicación
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene la fecha de creación de la publicación.
     * 
     * Este método devuelve la fecha en que fue creada
     * la publicación en el sistema.
     * 
     * @return La fecha de creación de la publicación
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    /**
     * Establece la fecha de creación de la publicación.
     * 
     * Este método permite actualizar la fecha de creación
     * de la publicación en caso de correcciones.
     * 
     * @param fechaCreacion La nueva fecha de creación de la publicación
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Método abstracto para obtener el tipo específico de publicación.
     * 
     * Este método debe ser implementado por cada clase hija para
     * devolver el tipo específico de publicación (Evento, Promoción).
     * Permite categorizar y diferenciar los tipos de publicaciones.
     * 
     * @return El tipo específico de publicación
     */
    public abstract String getTipo();
    
    /**
     * Genera una representación en texto de la publicación.
     * 
     * Este método crea una cadena de texto que contiene la información
     * completa de la publicación, incluyendo ID, título, descripción,
     * fecha de creación y tipo.
     * 
     * @return Una cadena con la información completa de la publicación
     */
    @Override
    public String toString() {
        return "Publicacion{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", tipo='" + getTipo() + '\'' +
                '}';
    }
    
    /**
     * Compara si dos publicaciones son iguales basándose en su ID.
     * 
     * Este método permite determinar si dos objetos Publicacion representan
     * a la misma publicación comparando sus identificadores únicos.
     * 
     * @param obj El objeto a comparar
     * @return true si las publicaciones tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Publicacion that = (Publicacion) obj;
        return id != null ? id.equals(that.id) : that.id == null;
    }
    
    /**
     * Genera un código hash basado en el ID de la publicación.
     * 
     * Este método es utilizado por las estructuras de datos como HashMap
     * para organizar y buscar objetos Publicacion de manera eficiente.
     * 
     * @return El código hash de la publicación basado en su ID
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
