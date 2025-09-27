package udistrital.avanzada.rolapet.controlador;

import udistrital.avanzada.rolapet.modelo.*;
import java.util.List;

/**
 * Interfaz que define el contrato de servicio para el controlador del sistema RolaPet.
 * 
 * Esta interfaz establece las operaciones principales que la vista puede invocar,
 * siguiendo el principio de inversión de dependencias (DIP) de SOLID. Define
 * todos los métodos que el controlador debe implementar para gestionar
 * las operaciones del sistema de manera consistente.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public interface IControladorRolaPET {
    
    // === MÉTODOS DE AUTENTICACIÓN ===
    
    /**
     * Autentica un usuario en el sistema utilizando email y contraseña.
     * 
     * Este método verifica las credenciales del usuario y devuelve
     * el objeto Usuario si la autenticación es exitosa. Es utilizado
     * por la vista para permitir el acceso al sistema a usuarios regulares.
     * 
     * @param email    Dirección de correo electrónico del usuario
     * @param password Contraseña de acceso del usuario
     * @return El usuario autenticado o null si las credenciales son inválidas
     */
    Usuario autenticarUsuario(String email, String password);
    
    /**
     * Autentica un administrador en el sistema utilizando cédula y contraseña.
     * 
     * Este método verifica las credenciales del administrador y devuelve
     * el objeto Administrador si la autenticación es exitosa. Es utilizado
     * por la vista para permitir el acceso administrativo al sistema.
     * 
     * @param cedula   Cédula de identificación del administrador
     * @param password Contraseña de acceso del administrador
     * @return El administrador autenticado o null si las credenciales son inválidas
     */
    Administrador autenticarAdministrador(String cedula, String password);
    
    /**
     * Autentica un proveedor en el sistema utilizando cédula y contraseña.
     * 
     * Este método verifica las credenciales del proveedor y devuelve
     * el objeto Proveedor si la autenticación es exitosa. Es utilizado
     * por la vista para permitir el acceso de proveedores al sistema.
     * 
     * @param cedula   Cédula de identificación del proveedor
     * @param password Contraseña de acceso del proveedor
     * @return El proveedor autenticado o null si las credenciales son inválidas
     */
    Proveedor autenticarProveedor(String cedula, String password);
    
    // === MÉTODOS DE REGISTRO ===
    
    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * Este método crea un nuevo usuario con los datos proporcionados
     * y lo almacena en el repositorio. Verifica que no exista otro
     * usuario con la misma cédula o email antes de proceder.
     * 
     * @param cedula   Cédula de identificación del usuario
     * @param nombre   Nombre completo del usuario
     * @param telefono Número de teléfono del usuario
     * @param password Contraseña de acceso del usuario
     * @param email    Dirección de correo electrónico del usuario
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registrarUsuario(String cedula, String nombre, String telefono, String password, String email);
    
    /**
     * Registra un nuevo administrador en el sistema.
     * 
     * Este método crea un nuevo administrador con los datos proporcionados
     * y lo almacena en el repositorio. Verifica que no exista otra
     * persona con la misma cédula antes de proceder.
     * 
     * @param cedula   Cédula de identificación del administrador
     * @param nombre   Nombre completo del administrador
     * @param telefono Número de teléfono del administrador
     * @param password Contraseña de acceso del administrador
     * @param email    Dirección de correo electrónico del administrador
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registrarAdministrador(String cedula, String nombre, String telefono, String password, String email);
    
    /**
     * Registra un nuevo proveedor en el sistema.
     * 
     * Este método crea un nuevo proveedor con los datos proporcionados
     * y lo almacena en el repositorio. Verifica que no exista otra
     * persona con la misma cédula antes de proceder.
     * 
     * @param cedula   Cédula de identificación del proveedor
     * @param nombre   Nombre completo del proveedor
     * @param telefono Número de teléfono del proveedor
     * @param password Contraseña de acceso del proveedor
     * @param email    Dirección de correo electrónico del proveedor
     * @return true si el registro fue exitoso, false en caso contrario
     */
    boolean registrarProveedor(String cedula, String nombre, String telefono, String password, String email);
    
    // === MÉTODOS DE GESTIÓN DE AMIGOS ===
    
    /**
     * Agrega un amigo a la lista de amigos de un usuario.
     * 
     * Este método permite a un usuario agregar otro usuario como amigo,
     * estableciendo una relación social en el sistema. Verifica que
     * ambos usuarios existan y que no sean la misma persona.
     * 
     * @param cedulaUsuarioActual Cédula del usuario que agrega al amigo
     * @param cedulaAmigo         Cédula del usuario a agregar como amigo
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarAmigo(String cedulaUsuarioActual, String cedulaAmigo);
    
    /**
     * Elimina un amigo de la lista de amigos de un usuario.
     * 
     * Este método permite a un usuario remover otro usuario de su
     * lista de amigos, terminando la relación social.
     * 
     * @param cedulaUsuarioActual Cédula del usuario que elimina al amigo
     * @param cedulaAmigo         Cédula del usuario a eliminar de amigos
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    boolean eliminarAmigo(String cedulaUsuarioActual, String cedulaAmigo);
    
    /**
     * Obtiene la lista de amigos de un usuario.
     * 
     * Este método devuelve todos los usuarios que están en la
     * lista de amigos del usuario especificado.
     * 
     * @param cedulaUsuario Cédula del usuario del cual obtener los amigos
     * @return Lista de amigos del usuario
     */
    List<Usuario> obtenerAmigos(String cedulaUsuario);
    
    // === MÉTODOS DE GESTIÓN DE VEHÍCULOS ===
    
    /**
     * Consulta los vehículos de un usuario específico.
     * 
     * Este método devuelve todos los vehículos que están
     * asociados al usuario especificado.
     * 
     * @param cedulaUsuario Cédula del usuario del cual obtener los vehículos
     * @return Lista de vehículos del usuario
     */
    List<Vehiculo> consultarVehiculosDeUsuario(String cedulaUsuario);
    
    /**
     * Agrega un vehículo a la lista de vehículos de un usuario.
     * 
     * Este método asocia un vehículo existente con un usuario,
     * permitiendo que el usuario tenga acceso a ese vehículo.
     * 
     * @param cedulaUsuario Cédula del usuario al cual agregar el vehículo
     * @param vehiculo      Vehículo a asociar con el usuario
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarVehiculoAUsuario(String cedulaUsuario, Vehiculo vehiculo);
    
    /**
     * Elimina un vehículo de la lista de vehículos de un usuario.
     * 
     * Este método desasocia un vehículo de un usuario,
     * removiendo el acceso del usuario a ese vehículo.
     * 
     * @param cedulaUsuario Cédula del usuario del cual eliminar el vehículo
     * @param idVehiculo    ID del vehículo a desasociar del usuario
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    boolean eliminarVehiculoDeUsuario(String cedulaUsuario, String idVehiculo);
    
    /**
     * Crea un nuevo vehículo en el sistema.
     * 
     * Este método crea un nuevo vehículo con las características
     * especificadas y lo registra en el repositorio. El tipo de
     * vehículo determina la clase concreta que se instancia.
     * 
     * @param marca      Marca comercial del vehículo
     * @param modelo     Modelo específico del vehículo
     * @param autonomiaKm Autonomía en kilómetros del vehículo
     * @param tipo       Tipo de vehículo (Scooter, MotoElectrica)
     * @return El vehículo creado o null si hubo error
     */
    Vehiculo crearVehiculo(String marca, String modelo, int autonomiaKm, String tipo);
    
    // === MÉTODOS DE GESTIÓN DE ITEMS ===
    
    /**
     * Crea un nuevo item en el sistema.
     * 
     * Este método crea un nuevo item (servicio o producto) con las
     * características especificadas y lo registra en el repositorio.
     * El tipo de item determina la clase concreta que se instancia.
     * 
     * @param nombre      Nombre comercial del item
     * @param descripcion Descripción detallada del item
     * @param tipo        Tipo de item (Servicio, Producto)
     * @return El item creado o null si hubo error
     */
    Item crearItem(String nombre, String descripcion, String tipo);
    
    /**
     * Agrega un item al catálogo de un proveedor.
     * 
     * Este método asocia un item existente con un proveedor,
     * permitiendo que el proveedor ofrezca ese item.
     * 
     * @param cedulaProveedor Cédula del proveedor al cual agregar el item
     * @param item           Item a asociar con el proveedor
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarItemAProveedor(String cedulaProveedor, Item item);
    
    /**
     * Obtiene los items que ofrece un proveedor.
     * 
     * Este método devuelve todos los items que están
     * asociados al proveedor especificado.
     * 
     * @param cedulaProveedor Cédula del proveedor del cual obtener los items
     * @return Lista de items del proveedor
     */
    List<Item> obtenerItemsDeProveedor(String cedulaProveedor);
    
    // === MÉTODOS DE GESTIÓN DE PUBLICACIONES ===
    
    /**
     * Crea una nueva publicación en el sistema.
     * 
     * Este método crea una nueva publicación (evento o promoción) con las
     * características especificadas y la registra en el repositorio.
     * 
     * @param titulo       Título descriptivo de la publicación
     * @param descripcion  Descripción detallada de la publicación
     * @param tipo         Tipo de publicación (Evento, Promocion)
     * @return La publicación creada o null si hubo error
     */
    Publicacion crearPublicacion(String titulo, String descripcion, String tipo);
    
    /**
     * Agrega una publicación al perfil de un proveedor.
     * 
     * Este método asocia una publicación existente con un proveedor,
     * permitiendo que el proveedor publique esa información.
     * 
     * @param cedulaProveedor Cédula del proveedor al cual agregar la publicación
     * @param publicacion    Publicación a asociar con el proveedor
     * @return true si se agregó exitosamente, false en caso contrario
     */
    boolean agregarPublicacionAProveedor(String cedulaProveedor, Publicacion publicacion);
    
    /**
     * Obtiene las publicaciones de un proveedor.
     * 
     * Este método devuelve todas las publicaciones que están
     * asociadas al proveedor especificado.
     * 
     * @param cedulaProveedor Cédula del proveedor del cual obtener las publicaciones
     * @return Lista de publicaciones del proveedor
     */
    List<Publicacion> obtenerPublicacionesDeProveedor(String cedulaProveedor);
    
    // === MÉTODOS DE CONSULTA GENERAL ===
    
    /**
     * Obtiene todas las personas registradas en el sistema.
     * 
     * Este método devuelve una lista completa de todas las personas
     * (usuarios, administradores y proveedores) registradas en el sistema.
     * Es útil para reportes administrativos.
     * 
     * @return Lista de todas las personas del sistema
     */
    List<Persona> obtenerTodasLasPersonas();
    
    /**
     * Obtiene todos los vehículos registrados en el sistema.
     * 
     * Este método devuelve una lista completa de todos los vehículos
     * registrados en el sistema. Es útil para reportes y estadísticas.
     * 
     * @return Lista de todos los vehículos del sistema
     */
    List<Vehiculo> obtenerTodosLosVehiculos();
    
    /**
     * Obtiene todos los items registrados en el sistema.
     * 
     * Este método devuelve una lista completa de todos los items
     * (servicios y productos) registrados en el sistema.
     * Es útil para catálogos generales.
     * 
     * @return Lista de todos los items del sistema
     */
    List<Item> obtenerTodosLosItems();
    
    /**
     * Obtiene todas las publicaciones registradas en el sistema.
     * 
     * Este método devuelve una lista completa de todas las publicaciones
     * (eventos y promociones) registradas en el sistema.
     * Es útil para mostrar novedades y ofertas.
     * 
     * @return Lista de todas las publicaciones del sistema
     */
    List<Publicacion> obtenerTodasLasPublicaciones();
    
    /**
     * Obtiene estadísticas generales del sistema.
     * 
     * Este método genera un reporte con estadísticas detalladas
     * del sistema, incluyendo número de usuarios, vehículos, items
     * y publicaciones. Es útil para monitoreo y análisis.
     * 
     * @return String con las estadísticas detalladas del sistema
     */
    String obtenerEstadisticasSistema();
}
