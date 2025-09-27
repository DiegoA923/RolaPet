package com.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Singleton que actúa como la base de datos en memoria del sistema RolaPet.
 * 
 * Esta clase implementa el patrón Singleton para garantizar que solo exista
 * una instancia del repositorio en toda la aplicación, centralizando el
 * almacenamiento de datos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Repositorio {
    
    /** Instancia única del repositorio (Singleton) */
    private static Repositorio instancia;
    
    /** Lista de todas las personas en el sistema */
    private List<Persona> personas;
    
    /** Lista de todos los vehículos en el sistema */
    private List<Vehiculo> vehiculos;
    
    /** Lista de todos los items en el sistema */
    private List<Item> items;
    
    /** Lista de todas las publicaciones en el sistema */
    private List<Publicacion> publicaciones;
    
    /**
     * Constructor privado para implementar el patrón Singleton.
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
     * @param persona La persona a guardar
     * @return true si se guardó exitosamente, false si ya existe
     */
    public boolean guardarPersona(Persona persona) {
        if (persona != null && !personas.contains(persona)) {
            personas.add(persona);
            return true;
        }
        return false;
    }
    
    /**
     * Busca una persona por su cédula.
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
     * Busca un usuario por su email.
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
     * Obtiene todos los usuarios del sistema.
     * 
     * @return Lista de todos los usuarios
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return personas.stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene todos los administradores del sistema.
     * 
     * @return Lista de todos los administradores
     */
    public List<Administrador> obtenerTodosLosAdministradores() {
        return personas.stream()
                .filter(p -> p instanceof Administrador)
                .map(p -> (Administrador) p)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene todos los proveedores del sistema.
     * 
     * @return Lista de todos los proveedores
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
     * @param persona La persona a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarPersona(Persona persona) {
        return personas.remove(persona);
    }
    
    // === MÉTODOS PARA GESTIÓN DE VEHÍCULOS ===
    
    /**
     * Guarda un vehículo en el repositorio.
     * 
     * @param vehiculo El vehículo a guardar
     * @return true si se guardó exitosamente, false si ya existe
     */
    public boolean guardarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            return true;
        }
        return false;
    }
    
    /**
     * Busca un vehículo por su ID.
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
     * Obtiene todos los vehículos del sistema.
     * 
     * @return Lista de todos los vehículos
     */
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return new ArrayList<>(vehiculos);
    }
    
    /**
     * Elimina un vehículo del repositorio.
     * 
     * @param vehiculo El vehículo a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }
    
    // === MÉTODOS PARA GESTIÓN DE ITEMS ===
    
    /**
     * Guarda un item en el repositorio.
     * 
     * @param item El item a guardar
     * @return true si se guardó exitosamente, false si ya existe
     */
    public boolean guardarItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
            return true;
        }
        return false;
    }
    
    /**
     * Busca un item por su ID.
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
     * Obtiene todos los items del sistema.
     * 
     * @return Lista de todos los items
     */
    public List<Item> obtenerTodosLosItems() {
        return new ArrayList<>(items);
    }
    
    /**
     * Elimina un item del repositorio.
     * 
     * @param item El item a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarItem(Item item) {
        return items.remove(item);
    }
    
    // === MÉTODOS PARA GESTIÓN DE PUBLICACIONES ===
    
    /**
     * Guarda una publicación en el repositorio.
     * 
     * @param publicacion La publicación a guardar
     * @return true si se guardó exitosamente, false si ya existe
     */
    public boolean guardarPublicacion(Publicacion publicacion) {
        if (publicacion != null && !publicaciones.contains(publicacion)) {
            publicaciones.add(publicacion);
            return true;
        }
        return false;
    }
    
    /**
     * Busca una publicación por su ID.
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
     * Obtiene todas las publicaciones del sistema.
     * 
     * @return Lista de todas las publicaciones
     */
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return new ArrayList<>(publicaciones);
    }
    
    /**
     * Elimina una publicación del repositorio.
     * 
     * @param publicacion La publicación a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicaciones.remove(publicacion);
    }
    
    // === MÉTODOS DE ESTADÍSTICAS ===
    
    /**
     * Obtiene todas las personas del sistema.
     * 
     * @return Lista de todas las personas
     */
    public List<Persona> obtenerTodasLasPersonas() {
        return new ArrayList<>(personas);
    }
    
    /**
     * Obtiene estadísticas generales del repositorio.
     * 
     * @return String con las estadísticas del repositorio
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
