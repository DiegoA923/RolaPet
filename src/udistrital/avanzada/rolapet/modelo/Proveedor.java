package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa a un Proveedor en el sistema RolaPet.
 * 
 * Un Proveedor es una persona que puede ofrecer servicios o productos
 * a través del sistema. Esta clase define los comportamientos comunes
 * a todos los tipos de proveedores y maneja la gestión de items
 * y publicaciones que ofrecen.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Proveedor extends Persona {
    
    /** Dirección de correo electrónico del proveedor */
    private String email;
    
    /** Lista de items (servicios o productos) que ofrece el proveedor */
    private List<Item> items;
    
    /** Lista de publicaciones (eventos o promociones) del proveedor */
    private List<Publicacion> publicaciones;
    
    /**
     * Constructor de la clase Proveedor.
     * 
     * Este constructor crea un nuevo proveedor con la información básica
     * e inicializa las listas de items y publicaciones como listas vacías.
     * 
     * @param cedula   Cédula de identificación del proveedor
     * @param nombre   Nombre completo del proveedor
     * @param telefono Número de teléfono del proveedor
     * @param password Contraseña de acceso del proveedor
     * @param email    Dirección de correo electrónico del proveedor
     */
    public Proveedor(String cedula, String nombre, String telefono, String password, String email) {
        super(cedula, nombre, telefono, password);
        this.email = email;
        this.items = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }
    
    /**
     * Obtiene la dirección de correo electrónico del proveedor.
     * 
     * Este método devuelve el email registrado del proveedor,
     * que se utiliza para comunicación y notificaciones.
     * 
     * @return La dirección de email del proveedor
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece la dirección de correo electrónico del proveedor.
     * 
     * Este método permite actualizar el email del proveedor
     * en caso de cambios o correcciones.
     * 
     * @param email La nueva dirección de email del proveedor
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene la lista de items que ofrece el proveedor.
     * 
     * Este método devuelve una copia de la lista de items
     * para evitar modificaciones externas no controladas.
     * 
     * @return Lista de items que ofrece el proveedor
     */
    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
    
    /**
     * Agrega un item a la lista del proveedor.
     * 
     * Este método permite al proveedor agregar un nuevo item
     * (servicio o producto) a su catálogo, verificando que no esté duplicado.
     * 
     * @param item El item a agregar al catálogo del proveedor
     * @return true si el item se agregó exitosamente, false si ya existía
     */
    public boolean agregarItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
            return true;
        }
        return false;
    }
    
    /**
     * Elimina un item de la lista del proveedor.
     * 
     * Este método permite al proveedor remover un item
     * de su catálogo de ofertas.
     * 
     * @param item El item a eliminar del catálogo del proveedor
     * @return true si el item se eliminó exitosamente, false si no existía
     */
    public boolean eliminarItem(Item item) {
        return items.remove(item);
    }
    
    /**
     * Obtiene la lista de publicaciones del proveedor.
     * 
     * Este método devuelve una copia de la lista de publicaciones
     * para evitar modificaciones externas no controladas.
     * 
     * @return Lista de publicaciones del proveedor
     */
    public List<Publicacion> getPublicaciones() {
        return new ArrayList<>(publicaciones);
    }
    
    /**
     * Agrega una publicación a la lista del proveedor.
     * 
     * Este método permite al proveedor crear una nueva publicación
     * (evento o promoción) para promocionar sus servicios o productos.
     * 
     * @param publicacion La publicación a agregar al perfil del proveedor
     * @return true si la publicación se agregó exitosamente, false si ya existía
     */
    public boolean agregarPublicacion(Publicacion publicacion) {
        if (publicacion != null && !publicaciones.contains(publicacion)) {
            publicaciones.add(publicacion);
            return true;
        }
        return false;
    }
    
    /**
     * Elimina una publicación de la lista del proveedor.
     * 
     * Este método permite al proveedor remover una publicación
     * de su perfil.
     * 
     * @param publicacion La publicación a eliminar del perfil del proveedor
     * @return true si la publicación se eliminó exitosamente, false si no existía
     */
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicaciones.remove(publicacion);
    }
    
    /**
     * Genera una representación en texto del proveedor.
     * 
     * Este método crea una cadena de texto que contiene la información
     * completa del proveedor, incluyendo datos personales, rol y
     * estadísticas de items y publicaciones.
     * 
     * @return Una cadena con la información completa del proveedor
     */
    @Override
    public String toString() {
        return "Proveedor{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + getRol() + '\'' +
                ", items=" + items.size() +
                ", publicaciones=" + publicaciones.size() +
                '}';
    }
}