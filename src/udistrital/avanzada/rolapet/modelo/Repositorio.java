package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Singleton que actúa como la base de datos en memoria del sistema RolaPet.
 * 
 * Esta clase implementa el patrón Singleton para garantizar que solo exista
 * una instancia del repositorio en toda la aplicación, centralizando el
 * almacenamiento de datos. Funciona como una base de datos en memoria que
 * mantiene todas las entidades del sistema organizadas y accesibles.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Repositorio {
    
    /** Instancia única del repositorio (implementación del patrón Singleton) */
    private static Repositorio instancia;
    
    /** Lista de todas las personas registradas en el sistema */
    private List<Persona> personas;
    
    /** Lista de todos los vehículos registrados en el sistema */
    private List<Vehiculo> vehiculos;
    
    /** Lista de todos los items (servicios y productos) registrados en el sistema */
    private List<Item> items;
    
    /** Lista de todas las publicaciones registradas en el sistema */
    private List<Publicacion> publicaciones;
    
    /**
     * Constructor privado para implementar el patrón Singleton.
     * 
     * Este constructor inicializa todas las listas de datos como listas vacías,
     * preparando el repositorio para almacenar las entidades del sistema.
     * Es privado para evitar la creación de múltiples instancias.
     */
    private Repositorio() {
        this.personas = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.items = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }
    
    /**
     * Obtiene la instancia única del repositorio.
     * 
     * Este método implementa el patrón Singleton, garantizando que solo
     * exista una instancia del repositorio en toda la aplicación.
     * Si no existe una instancia, la crea; si ya existe, devuelve la existente.
     * 
     * @return La instancia única del repositorio
     */
    public static synchronized Repositorio getInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }
    
    // === MÉTODOS PARA GESTIÓN DE PERSONAS ===
    
    /**
     * Guarda una persona en el repositorio.
     * 
     * Este método agrega una nueva persona al sistema, verificando que
     * no sea nula y que no esté duplicada. Es utilizado para registrar
     * usuarios, administradores y proveedores.
     * 
     * @param persona La persona a guardar en el repositorio
     * @return true si la persona se guardó exitosamente, false si ya existe o es nula
     */
    public boolean guardarPersona(Persona persona) {
        if (persona != null && !personas.contains(persona)) {
            personas.add(persona);
            return true;
        }
        return false;
    }
    
    /**
     * Busca una persona por su cédula de identificación.
     * 
     * Este método recorre la lista de personas para encontrar aquella
     * que tenga la cédula especificada. Es útil para verificar si una
     * persona ya está registrada o para obtener sus datos.
     * 
     * @param cedula La cédula de la persona a buscar
     * @return La persona encontrada o null si no existe
     */
    public Persona buscarPersonaPorCedula(String cedula) {
        return personas.stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Busca un usuario por su dirección de correo electrónico.
     * 
     * Este método busca específicamente entre los usuarios registrados
     * para encontrar aquel que tenga el email especificado. Es utilizado
     * para el proceso de autenticación de usuarios.
     * 
     * @param email El email del usuario a buscar
     * @return El usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        return personas.stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p)
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Obtiene todos los usuarios registrados en el sistema.
     * 
     * Este método filtra la lista de personas para devolver solo
     * aquellas que son instancias de Usuario. Es útil para generar
     * reportes o listados de usuarios.
     * 
     * @return Lista de todos los usuarios del sistema
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return personas.stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene todos los administradores registrados en el sistema.
     * 
     * Este método filtra la lista de personas para devolver solo
     * aquellas que son instancias de Administrador. Es útil para
     * gestionar privilegios administrativos.
     * 
     * @return Lista de todos los administradores del sistema
     */
    public List<Administrador> obtenerTodosLosAdministradores() {
        return personas.stream()
                .filter(p -> p instanceof Administrador)
                .map(p -> (Administrador) p)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene todos los proveedores registrados en el sistema.
     * 
     * Este método filtra la lista de personas para devolver solo
     * aquellas que son instancias de Proveedor. Es útil para
     * gestionar el catálogo de proveedores.
     * 
     * @return Lista de todos los proveedores del sistema
     */
    public List<Proveedor> obtenerTodosLosProveedores() {
        return personas.stream()
                .filter(p -> p instanceof Proveedor)
                .map(p -> (Proveedor) p)
                .collect(Collectors.toList());
    }
    
    /**
     * Elimina una persona del repositorio.
     * 
     * Este método remueve una persona específica del sistema.
     * Es utilizado para dar de baja usuarios, administradores o proveedores.
     * 
     * @param persona La persona a eliminar del repositorio
     * @return true si la persona se eliminó exitosamente, false si no existía
     */
    public boolean eliminarPersona(Persona persona) {
        return personas.remove(persona);
    }
    
    // === MÉTODOS PARA GESTIÓN DE VEHÍCULOS ===
    
    /**
     * Guarda un vehículo en el repositorio.
     * 
     * Este método agrega un nuevo vehículo al sistema, verificando que
     * no sea nulo y que no esté duplicado. Es utilizado para registrar
     * scooters, motos eléctricas y otros vehículos.
     * 
     * @param vehiculo El vehículo a guardar en el repositorio
     * @return true si el vehículo se guardó exitosamente, false si ya existe o es nulo
     */
    public boolean guardarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            return true;
        }
        return false;
    }
    
    /**
     * Busca un vehículo por su identificador único.
     * 
     * Este método recorre la lista de vehículos para encontrar aquel
     * que tenga el ID especificado. Es útil para verificar si un
     * vehículo ya está registrado o para obtener sus datos.
     * 
     * @param id El ID del vehículo a buscar
     * @return El vehículo encontrado o null si no existe
     */
    public Vehiculo buscarVehiculoPorId(String id) {
        return vehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Obtiene todos los vehículos registrados en el sistema.
     * 
     * Este método devuelve una copia de la lista de vehículos
     * para evitar modificaciones externas no controladas.
     * Es útil para generar reportes o listados de vehículos.
     * 
     * @return Lista de todos los vehículos del sistema
     */
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return new ArrayList<>(vehiculos);
    }
    
    /**
     * Elimina un vehículo del repositorio.
     * 
     * Este método remueve un vehículo específico del sistema.
     * Es utilizado para dar de baja vehículos que ya no están disponibles.
     * 
     * @param vehiculo El vehículo a eliminar del repositorio
     * @return true si el vehículo se eliminó exitosamente, false si no existía
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }
    
    // === MÉTODOS PARA GESTIÓN DE ITEMS ===
    
    /**
     * Guarda un item en el repositorio.
     * 
     * Este método agrega un nuevo item (servicio o producto) al sistema,
     * verificando que no sea nulo y que no esté duplicado. Es utilizado
     * para registrar servicios y productos de proveedores.
     * 
     * @param item El item a guardar en el repositorio
     * @return true si el item se guardó exitosamente, false si ya existe o es nulo
     */
    public boolean guardarItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
            return true;
        }
        return false;
    }
    
    /**
     * Busca un item por su identificador único.
     * 
     * Este método recorre la lista de items para encontrar aquel
     * que tenga el ID especificado. Es útil para verificar si un
     * item ya está registrado o para obtener sus datos.
     * 
     * @param id El ID del item a buscar
     * @return El item encontrado o null si no existe
     */
    public Item buscarItemPorId(String id) {
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Obtiene todos los items registrados en el sistema.
     * 
     * Este método devuelve una copia de la lista de items
     * para evitar modificaciones externas no controladas.
     * Es útil para generar reportes o catálogos de items.
     * 
     * @return Lista de todos los items del sistema
     */
    public List<Item> obtenerTodosLosItems() {
        return new ArrayList<>(items);
    }
    
    /**
     * Elimina un item del repositorio.
     * 
     * Este método remueve un item específico del sistema.
     * Es utilizado para dar de baja servicios o productos
     * que ya no están disponibles.
     * 
     * @param item El item a eliminar del repositorio
     * @return true si el item se eliminó exitosamente, false si no existía
     */
    public boolean eliminarItem(Item item) {
        return items.remove(item);
    }
    
    // === MÉTODOS PARA GESTIÓN DE PUBLICACIONES ===
    
    /**
     * Guarda una publicación en el repositorio.
     * 
     * Este método agrega una nueva publicación (evento o promoción) al sistema,
     * verificando que no sea nula y que no esté duplicada. Es utilizado
     * para registrar publicaciones de proveedores.
     * 
     * @param publicacion La publicación a guardar en el repositorio
     * @return true si la publicación se guardó exitosamente, false si ya existe o es nula
     */
    public boolean guardarPublicacion(Publicacion publicacion) {
        if (publicacion != null && !publicaciones.contains(publicacion)) {
            publicaciones.add(publicacion);
            return true;
        }
        return false;
    }
    
    /**
     * Busca una publicación por su identificador único.
     * 
     * Este método recorre la lista de publicaciones para encontrar aquella
     * que tenga el ID especificado. Es útil para verificar si una
     * publicación ya está registrada o para obtener sus datos.
     * 
     * @param id El ID de la publicación a buscar
     * @return La publicación encontrada o null si no existe
     */
    public Publicacion buscarPublicacionPorId(String id) {
        return publicaciones.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Obtiene todas las publicaciones registradas en el sistema.
     * 
     * Este método devuelve una copia de la lista de publicaciones
     * para evitar modificaciones externas no controladas.
     * Es útil para generar reportes o listados de publicaciones.
     * 
     * @return Lista de todas las publicaciones del sistema
     */
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return new ArrayList<>(publicaciones);
    }
    
    /**
     * Elimina una publicación del repositorio.
     * 
     * Este método remueve una publicación específica del sistema.
     * Es utilizado para dar de baja publicaciones que ya no están activas.
     * 
     * @param publicacion La publicación a eliminar del repositorio
     * @return true si la publicación se eliminó exitosamente, false si no existía
     */
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicaciones.remove(publicacion);
    }
    
    // === MÉTODOS DE ESTADÍSTICAS ===
    
    /**
     * Obtiene todas las personas registradas en el sistema.
     * 
     * Este método devuelve una copia de la lista de personas
     * para evitar modificaciones externas no controladas.
     * Es útil para generar reportes generales del sistema.
     * 
     * @return Lista de todas las personas del sistema
     */
    public List<Persona> obtenerTodasLasPersonas() {
        return new ArrayList<>(personas);
    }
    
    /**
     * Obtiene estadísticas generales del repositorio.
     * 
     * Este método genera un reporte con el número total de entidades
     * registradas en cada categoría del sistema. Es útil para
     * monitorear el crecimiento y uso del sistema.
     * 
     * @return String con las estadísticas detalladas del repositorio
     */
    public String obtenerEstadisticas() {
        return String.format(
            "Estadísticas del Repositorio:\n" +
            "Personas: %d\n" +
            "Usuarios: %d\n" +
            "Administradores: %d\n" +
            "Proveedores: %d\n" +
            "Vehículos: %d\n" +
            "Items: %d\n" +
            "Publicaciones: %d",
            personas.size(),
            obtenerTodosLosUsuarios().size(),
            obtenerTodosLosAdministradores().size(),
            obtenerTodosLosProveedores().size(),
            vehiculos.size(),
            items.size(),
            publicaciones.size()
        );
    }
}
