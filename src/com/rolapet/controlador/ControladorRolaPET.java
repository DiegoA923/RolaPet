package com.rolapet.controlador;

import com.rolapet.modelo.*;
import java.util.List;
import java.util.UUID;

/**
 * Implementación del controlador principal del sistema RolaPet.
 * 
 * Esta clase implementa la interfaz IControladorRolaPET y contiene
 * toda la lógica de negocio y orquestación de las operaciones del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class ControladorRolaPET implements IControladorRolaPET {
    
    /** Instancia del repositorio Singleton */
    private final Repositorio repositorio;
    
    /**
     * Constructor del controlador.
     * Obtiene la instancia del repositorio Singleton.
     */
    public ControladorRolaPET() {
        this.repositorio = Repositorio.getInstancia();
    }
    
    // === MÉTODOS DE AUTENTICACIÓN ===
    
    /**
     * Autentica un usuario en el sistema.
     * 
     * @param email    Email del usuario
     * @param password Contraseña del usuario
     * @return El usuario autenticado o null si las credenciales son inválidas
     */
    @Override
    public Usuario autenticarUsuario(String email, String password) {
        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        
        Usuario usuario = repositorio.buscarUsuarioPorEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }
    
    /**
     * Autentica un administrador en el sistema.
     * 
     * @param cedula   Cédula del administrador
     * @param password Contraseña del administrador
     * @return El administrador autenticado o null si las credenciales son inválidas
     */
    @Override
    public Administrador autenticarAdministrador(String cedula, String password) {
        if (cedula == null || password == null || cedula.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        
        Persona persona = repositorio.buscarPersonaPorCedula(cedula);
        if (persona instanceof Administrador) {
            Administrador admin = (Administrador) persona;
            if (admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }
    
    /**
     * Autentica un proveedor en el sistema.
     * 
     * @param cedula   Cédula del proveedor
     * @param password Contraseña del proveedor
     * @return El proveedor autenticado o null si las credenciales son inválidas
     */
    @Override
    public Proveedor autenticarProveedor(String cedula, String password) {
        if (cedula == null || password == null || cedula.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        
        Persona persona = repositorio.buscarPersonaPorCedula(cedula);
        if (persona instanceof Proveedor) {
            Proveedor proveedor = (Proveedor) persona;
            if (proveedor.getPassword().equals(password)) {
                return proveedor;
            }
        }
        return null;
    }
    
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
    @Override
    public boolean registrarUsuario(String cedula, String nombre, String telefono, String password, String email) {
        if (!validarDatosPersona(cedula, nombre, telefono, password, email)) {
            return false;
        }
        
        // Verificar si ya existe una persona con esa cédula o email
        if (repositorio.buscarPersonaPorCedula(cedula) != null) {
            return false;
        }
        
        if (repositorio.buscarUsuarioPorEmail(email) != null) {
            return false;
        }
        
        Usuario nuevoUsuario = new Usuario(cedula, nombre, telefono, password, email);
        return repositorio.guardarPersona(nuevoUsuario);
    }
    
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
    @Override
    public boolean registrarAdministrador(String cedula, String nombre, String telefono, String password, String email) {
        if (!validarDatosPersona(cedula, nombre, telefono, password, email)) {
            return false;
        }
        
        // Verificar si ya existe una persona con esa cédula
        if (repositorio.buscarPersonaPorCedula(cedula) != null) {
            return false;
        }
        
        Administrador nuevoAdmin = new Administrador(cedula, nombre, telefono, password, email);
        return repositorio.guardarPersona(nuevoAdmin);
    }
    
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
    @Override
    public boolean registrarProveedor(String cedula, String nombre, String telefono, String password, String email) {
        if (!validarDatosPersona(cedula, nombre, telefono, password, email)) {
            return false;
        }
        
        // Verificar si ya existe una persona con esa cédula
        if (repositorio.buscarPersonaPorCedula(cedula) != null) {
            return false;
        }
        
        Proveedor nuevoProveedor = new Proveedor(cedula, nombre, telefono, password, email) {
            @Override
            public String getRol() {
                return "Proveedor";
            }
        };
        return repositorio.guardarPersona(nuevoProveedor);
    }
    
    // === MÉTODOS DE GESTIÓN DE AMIGOS ===
    
    /**
     * Agrega un amigo a la lista de amigos de un usuario.
     * 
     * @param cedulaUsuarioActual Cédula del usuario actual
     * @param cedulaAmigo         Cédula del usuario a agregar como amigo
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarAmigo(String cedulaUsuarioActual, String cedulaAmigo) {
        if (cedulaUsuarioActual == null || cedulaAmigo == null || cedulaUsuarioActual.equals(cedulaAmigo)) {
            return false;
        }
        
        Persona personaActual = repositorio.buscarPersonaPorCedula(cedulaUsuarioActual);
        Persona personaAmigo = repositorio.buscarPersonaPorCedula(cedulaAmigo);
        
        if (personaActual instanceof Usuario && personaAmigo instanceof Usuario) {
            Usuario usuarioActual = (Usuario) personaActual;
            Usuario usuarioAmigo = (Usuario) personaAmigo;
            return usuarioActual.agregarAmigo(usuarioAmigo);
        }
        return false;
    }
    
    /**
     * Elimina un amigo de la lista de amigos de un usuario.
     * 
     * @param cedulaUsuarioActual Cédula del usuario actual
     * @param cedulaAmigo         Cédula del usuario a eliminar de amigos
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    @Override
    public boolean eliminarAmigo(String cedulaUsuarioActual, String cedulaAmigo) {
        if (cedulaUsuarioActual == null || cedulaAmigo == null) {
            return false;
        }
        
        Persona personaActual = repositorio.buscarPersonaPorCedula(cedulaUsuarioActual);
        Persona personaAmigo = repositorio.buscarPersonaPorCedula(cedulaAmigo);
        
        if (personaActual instanceof Usuario && personaAmigo instanceof Usuario) {
            Usuario usuarioActual = (Usuario) personaActual;
            Usuario usuarioAmigo = (Usuario) personaAmigo;
            return usuarioActual.eliminarAmigo(usuarioAmigo);
        }
        return false;
    }
    
    /**
     * Obtiene la lista de amigos de un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @return Lista de amigos del usuario
     */
    @Override
    public List<Usuario> obtenerAmigos(String cedulaUsuario) {
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        if (persona instanceof Usuario) {
            return ((Usuario) persona).getAmigos();
        }
        return List.of();
    }
    
    // === MÉTODOS DE GESTIÓN DE VEHÍCULOS ===
    
    /**
     * Consulta los vehículos de un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @return Lista de vehículos del usuario
     */
    @Override
    public List<Vehiculo> consultarVehiculosDeUsuario(String cedulaUsuario) {
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        if (persona instanceof Usuario) {
            return ((Usuario) persona).getVehiculos();
        }
        return List.of();
    }
    
    /**
     * Agrega un vehículo a un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @param vehiculo      Vehículo a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarVehiculoAUsuario(String cedulaUsuario, Vehiculo vehiculo) {
        if (cedulaUsuario == null || vehiculo == null) {
            return false;
        }
        
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        if (persona instanceof Usuario) {
            Usuario usuario = (Usuario) persona;
            boolean agregado = usuario.agregarVehiculo(vehiculo);
            if (agregado) {
                repositorio.guardarVehiculo(vehiculo);
            }
            return agregado;
        }
        return false;
    }
    
    /**
     * Elimina un vehículo de un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @param idVehiculo    ID del vehículo a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    @Override
    public boolean eliminarVehiculoDeUsuario(String cedulaUsuario, String idVehiculo) {
        if (cedulaUsuario == null || idVehiculo == null) {
            return false;
        }
        
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        if (persona instanceof Usuario) {
            Usuario usuario = (Usuario) persona;
            Vehiculo vehiculo = repositorio.buscarVehiculoPorId(idVehiculo);
            if (vehiculo != null) {
                boolean eliminado = usuario.eliminarVehiculo(vehiculo);
                if (eliminado) {
                    repositorio.eliminarVehiculo(vehiculo);
                }
                return eliminado;
            }
        }
        return false;
    }
    
    /**
     * Crea un nuevo vehículo en el sistema.
     * 
     * @param marca      Marca del vehículo
     * @param modelo     Modelo del vehículo
     * @param autonomiaKm Autonomía en kilómetros
     * @param tipo       Tipo de vehículo (Scooter, MotoElectrica)
     * @return El vehículo creado o null si hubo error
     */
    @Override
    public Vehiculo crearVehiculo(String marca, String modelo, int autonomiaKm, String tipo) {
        if (marca == null || modelo == null || tipo == null || 
            marca.trim().isEmpty() || modelo.trim().isEmpty() || tipo.trim().isEmpty() ||
            autonomiaKm <= 0) {
            return null;
        }
        
        String id = generarIdUnico();
        Vehiculo vehiculo = null;
        
        switch (tipo.toLowerCase()) {
            case "scooter":
                vehiculo = new Scooter(id, marca, modelo, autonomiaKm);
                break;
            case "moto":
            case "moto electrica":
                vehiculo = new MotoElectrica(id, marca, modelo, autonomiaKm);
                break;
            default:
                return null;
        }
        
        if (vehiculo != null) {
            repositorio.guardarVehiculo(vehiculo);
        }
        
        return vehiculo;
    }
    
    // === MÉTODOS DE GESTIÓN DE ITEMS ===
    
    /**
     * Crea un nuevo item en el sistema.
     * 
     * @param nombre      Nombre del item
     * @param descripcion Descripción del item
     * @param tipo        Tipo de item (Servicio, Producto)
     * @return El item creado o null si hubo error
     */
    @Override
    public Item crearItem(String nombre, String descripcion, String tipo) {
        if (nombre == null || descripcion == null || tipo == null ||
            nombre.trim().isEmpty() || descripcion.trim().isEmpty() || tipo.trim().isEmpty()) {
            return null;
        }
        
        String id = generarIdUnico();
        Item item = null;
        
        switch (tipo.toLowerCase()) {
            case "servicio":
                item = new Servicio(id, nombre, descripcion);
                break;
            case "producto":
                item = new Producto(id, nombre, descripcion);
                break;
            default:
                return null;
        }
        
        if (item != null) {
            repositorio.guardarItem(item);
        }
        
        return item;
    }
    
    /**
     * Agrega un item a un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @param item           Item a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarItemAProveedor(String cedulaProveedor, Item item) {
        if (cedulaProveedor == null || item == null) {
            return false;
        }
        
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        if (persona instanceof Proveedor) {
            Proveedor proveedor = (Proveedor) persona;
            return proveedor.agregarItem(item);
        }
        return false;
    }
    
    /**
     * Obtiene los items de un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @return Lista de items del proveedor
     */
    @Override
    public List<Item> obtenerItemsDeProveedor(String cedulaProveedor) {
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        if (persona instanceof Proveedor) {
            return ((Proveedor) persona).getItems();
        }
        return List.of();
    }
    
    // === MÉTODOS DE GESTIÓN DE PUBLICACIONES ===
    
    /**
     * Crea una nueva publicación en el sistema.
     * 
     * @param titulo       Título de la publicación
     * @param descripcion  Descripción de la publicación
     * @param tipo         Tipo de publicación (Evento, Promocion)
     * @return La publicación creada o null si hubo error
     */
    @Override
    public Publicacion crearPublicacion(String titulo, String descripcion, String tipo) {
        if (titulo == null || descripcion == null || tipo == null ||
            titulo.trim().isEmpty() || descripcion.trim().isEmpty() || tipo.trim().isEmpty()) {
            return null;
        }
        
        String id = generarIdUnico();
        String fechaCreacion = java.time.LocalDate.now().toString();
        
        Publicacion publicacion = new Publicacion(id, titulo, descripcion, fechaCreacion) {
            @Override
            public String getTipo() {
                return tipo;
            }
        };
        
        repositorio.guardarPublicacion(publicacion);
        return publicacion;
    }
    
    /**
     * Agrega una publicación a un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @param publicacion    Publicación a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarPublicacionAProveedor(String cedulaProveedor, Publicacion publicacion) {
        if (cedulaProveedor == null || publicacion == null) {
            return false;
        }
        
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        if (persona instanceof Proveedor) {
            Proveedor proveedor = (Proveedor) persona;
            return proveedor.agregarPublicacion(publicacion);
        }
        return false;
    }
    
    /**
     * Obtiene las publicaciones de un proveedor.
     * 
     * @param cedulaProveedor Cédula del proveedor
     * @return Lista de publicaciones del proveedor
     */
    @Override
    public List<Publicacion> obtenerPublicacionesDeProveedor(String cedulaProveedor) {
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        if (persona instanceof Proveedor) {
            return ((Proveedor) persona).getPublicaciones();
        }
        return List.of();
    }
    
    // === MÉTODOS DE CONSULTA GENERAL ===
    
    /**
     * Obtiene todas las personas del sistema.
     * 
     * @return Lista de todas las personas
     */
    @Override
    public List<Persona> obtenerTodasLasPersonas() {
        return repositorio.obtenerTodasLasPersonas();
    }
    
    /**
     * Obtiene todos los vehículos del sistema.
     * 
     * @return Lista de todos los vehículos
     */
    @Override
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return repositorio.obtenerTodosLosVehiculos();
    }
    
    /**
     * Obtiene todos los items del sistema.
     * 
     * @return Lista de todos los items
     */
    @Override
    public List<Item> obtenerTodosLosItems() {
        return repositorio.obtenerTodosLosItems();
    }
    
    /**
     * Obtiene todas las publicaciones del sistema.
     * 
     * @return Lista de todas las publicaciones
     */
    @Override
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return repositorio.obtenerTodasLasPublicaciones();
    }
    
    /**
     * Obtiene estadísticas del sistema.
     * 
     * @return String con las estadísticas del sistema
     */
    @Override
    public String obtenerEstadisticasSistema() {
        return repositorio.obtenerEstadisticas();
    }
    
    // === MÉTODOS PRIVADOS DE UTILIDAD ===
    
    /**
     * Valida los datos básicos de una persona.
     * 
     * @param cedula   Cédula a validar
     * @param nombre   Nombre a validar
     * @param telefono Teléfono a validar
     * @param password Contraseña a validar
     * @param email    Email a validar
     * @return true si todos los datos son válidos, false en caso contrario
     */
    private boolean validarDatosPersona(String cedula, String nombre, String telefono, String password, String email) {
        return cedula != null && !cedula.trim().isEmpty() &&
               nombre != null && !nombre.trim().isEmpty() &&
               telefono != null && !telefono.trim().isEmpty() &&
               password != null && !password.trim().isEmpty() &&
               email != null && !email.trim().isEmpty() &&
               email.contains("@");
    }
    
    /**
     * Genera un ID único para las entidades del sistema.
     * 
     * @return ID único generado
     */
    private String generarIdUnico() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
