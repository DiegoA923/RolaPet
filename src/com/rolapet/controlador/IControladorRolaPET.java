package com.rolapet.controlador;

import com.rolapet.modelo.*;
import java.util.List;

/**
 * Interfaz que define el contrato de servicio para el controlador del sistema RolaPet.
 * 
 * Esta interfaz establece las operaciones principales que la vista puede invocar,
 * siguiendo el principio de inversión de dependencias (DIP) de SOLID.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public interface IControladorRolaPET {
    
    // === MÉTODOS DE AUTENTICACIÓN ===
    
    /**
     * Autentica un usuario en el sistema.
     * 
     * @param email    Email del usuario
     * @param password Contraseña del usuario
     * @return El usuario autenticado o null si las credenciales son inválidas
     */
    Usuario autenticarUsuario(String email, String password);
    
    /**
     * Autentica un administrador en el sistema.
     * 
     * @param cedula   Cédula del administrador
     * @param password Contraseña del administrador
     * @return El administrador autenticado o null si las credenciales son inválidas
     */
    Administrador autenticarAdministrador(String cedula, String password);
    
    /**
     * Autentica un proveedor en el sistema.
     * 
     * @param cedula   Cédula del proveedor
     * @param password Contraseña del proveedor
     * @return El proveedor autenticado o null si las credenciales son inválidas
     */
    Proveedor autenticarProveedor(String cedula, String password);
    
    // === MÉTODOS DE REGISTRO ===
    
    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param cedula   Cédula del usuario
     * @param nombre   Nombre del usuario
     * @param telefono Teléfono del usuario
     * @param password Contraseña del usuario
     * @param email    Email del usuario
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registrarUsuario(String cedula, String nombre, String telefono, String password, String email);
    
    /**
     * Registra un nuevo administrador en el sistema.
     * 
     * @param cedula   Cédula del administrador
     * @param nombre   Nombre del administrador
     * @param telefono Teléfono del administrador
     * @param password Contraseña del administrador
     * @param email    Email del administrador
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registrarAdministrador(String cedula, String nombre, String telefono, String password, String email);
    
    /**
     * Registra un nuevo proveedor en el sistema.
     * 
     * @param cedula   Cédula del proveedor
     * @param nombre   Nombre del proveedor
     * @param telefono Teléfono del proveedor
     * @param password Contraseña del proveedor
     * @param email    Email del proveedor
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registrarProveedor(String cedula, String nombre, String telefono, String password, String email);
    
    // === MÉTODOS DE GESTIÓN DE AMIGOS ===
    
    /**
     * Agrega un amigo a la lista de amigos de un usuario.
     * 
     * @param cedulaUsuarioActual Cédula del usuario actual
     * @param cedulaAmigo         Cédula del usuario a agregar como amigo
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarAmigo(String cedulaUsuarioActual, String cedulaAmigo);
    
    /**
     * Elimina un amigo de la lista de amigos de un usuario.
     * 
     * @param cedulaUsuarioActual Cédula del usuario actual
     * @param cedulaAmigo         Cédula del usuario a eliminar de amigos
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    boolean eliminarAmigo(String cedulaUsuarioActual, String cedulaAmigo);
    
    /**
     * Obtiene la lista de amigos de un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @return Lista de amigos del usuario
     */
    List<Usuario> obtenerAmigos(String cedulaUsuario);
    
    // === MÉTODOS DE GESTIÓN DE VEHÍCULOS ===
    
    /**
     * Consulta los vehículos de un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @return Lista de vehículos del usuario
     */
    List<Vehiculo> consultarVehiculosDeUsuario(String cedulaUsuario);
    
    /**
     * Agrega un vehículo a un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @param vehiculo      Vehículo a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarVehiculoAUsuario(String cedulaUsuario, Vehiculo vehiculo);
    
    /**
     * Elimina un vehículo de un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @param idVehiculo    ID del vehículo a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    boolean eliminarVehiculoDeUsuario(String cedulaUsuario, String idVehiculo);
    
    /**
     * Crea un nuevo vehículo en el sistema.
     * 
     * @param marca      Marca del vehículo
     * @param modelo     Modelo del vehículo
     * @param autonomiaKm Autonomía en kilómetros
     * @param tipo       Tipo de vehículo (Scooter, MotoElectrica)
     * @return El vehículo creado o null si hubo error
     */
    Vehiculo crearVehiculo(String marca, String modelo, int autonomiaKm, String tipo);
    
    // === MÉTODOS DE GESTIÓN DE ITEMS ===
    
    /**
     * Crea un nuevo item en el sistema.
     * 
     * @param nombre      Nombre del item
     * @param descripcion Descripción del item
     * @param tipo        Tipo de item (Servicio, Producto)
     * @return El item creado o null si hubo error
     */
    Item crearItem(String nombre, String descripcion, String tipo);
    
    /**
     * Agrega un item a un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @param item           Item a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarItemAProveedor(String cedulaProveedor, Item item);
    
    /**
     * Obtiene los items de un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @return Lista de items del proveedor
     */
    List<Item> obtenerItemsDeProveedor(String cedulaProveedor);
    
    // === MÉTODOS DE GESTIÓN DE PUBLICACIONES ===
    
    /**
     * Crea una nueva publicación en el sistema.
     * 
     * @param titulo       Título de la publicación
     * @param descripcion  Descripción de la publicación
     * @param tipo         Tipo de publicación (Evento, Promocion)
     * @return La publicación creada o null si hubo error
     */
    Publicacion crearPublicacion(String titulo, String descripcion, String tipo);
    
    /**
     * Agrega una publicación a un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @param publicacion    Publicación a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarPublicacionAProveedor(String cedulaProveedor, Publicacion publicacion);
    
    /**
     * Obtiene las publicaciones de un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @return Lista de publicaciones del proveedor
     */
    List<Publicacion> obtenerPublicacionesDeProveedor(String cedulaProveedor);
    
    // === MÉTODOS DE CONSULTA GENERAL ===
    
    /**
     * Obtiene todas las personas del sistema.
     * 
     * @return Lista de todas las personas
     */
    List<Persona> obtenerTodasLasPersonas();
    
    /**
     * Obtiene todos los vehículos del sistema.
     * 
     * @return Lista de todos los vehículos
     */
    List<Vehiculo> obtenerTodosLosVehiculos();
    
    /**
     * Obtiene todos los items del sistema.
     * 
     * @return Lista de todos los items
     */
    List<Item> obtenerTodosLosItems();
    
    /**
     * Obtiene todas las publicaciones del sistema.
     * 
     * @return Lista de todas las publicaciones
     */
    List<Publicacion> obtenerTodasLasPublicaciones();
    
    /**
     * Obtiene estadísticas del sistema.
     * 
     * @return String con las estadísticas del sistema
     */
    String obtenerEstadisticasSistema();
}
