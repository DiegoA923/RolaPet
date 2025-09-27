package udistrital.avanzada.rolapet.controlador;

import udistrital.avanzada.rolapet.modelo.*;
import java.util.List;
import java.util.UUID;

/**
 * Implementación del controlador principal del sistema RolaPet.
 * 
 * Esta clase implementa la interfaz IControladorRolaPET y contiene
 * toda la lógica de negocio y orquestación de las operaciones del sistema.
 * Actúa como intermediario entre la vista y el modelo, procesando las
 * solicitudes de la interfaz y coordinando las operaciones del repositorio.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class ControladorRolaPET implements IControladorRolaPET {
    
    /** Instancia del repositorio Singleton para acceso a los datos */
    private final Repositorio repositorio;
    
    /**
     * Constructor del controlador.
     * 
     * Este constructor inicializa el controlador obteniendo la instancia
     * del repositorio Singleton. Establece la conexión entre el controlador
     * y la capa de datos del sistema.
     */
    public ControladorRolaPET() {
        this.repositorio = Repositorio.getInstancia();
    }
    
    // === MÉTODOS DE AUTENTICACIÓN ===
    
    /**
     * Autentica un usuario en el sistema utilizando email y contraseña.
     * 
     * Este método verifica las credenciales del usuario buscando en el repositorio
     * un usuario con el email especificado y comparando la contraseña. Si las
     * credenciales son válidas, devuelve el objeto Usuario; en caso contrario,
     * devuelve null.
     * 
     * @param email    Dirección de correo electrónico del usuario
     * @param password Contraseña de acceso del usuario
     * @return El usuario autenticado o null si las credenciales son inválidas
     */
    @Override
    public Usuario autenticarUsuario(String email, String password) {
        // Validar que los parámetros no sean nulos o vacíos
        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        
        // Buscar el usuario por email en el repositorio
        Usuario usuario = repositorio.buscarUsuarioPorEmail(email);
        
        // Verificar que el usuario existe y la contraseña coincide
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        
        return null;
    }
    
    /**
     * Autentica un administrador en el sistema utilizando cédula y contraseña.
     * 
     * Este método verifica las credenciales del administrador buscando en el repositorio
     * una persona con la cédula especificada, verificando que sea un Administrador
     * y comparando la contraseña. Si las credenciales son válidas, devuelve el objeto
     * Administrador; en caso contrario, devuelve null.
     * 
     * @param cedula   Cédula de identificación del administrador
     * @param password Contraseña de acceso del administrador
     * @return El administrador autenticado o null si las credenciales son inválidas
     */
    @Override
    public Administrador autenticarAdministrador(String cedula, String password) {
        // Validar que los parámetros no sean nulos o vacíos
        if (cedula == null || password == null || cedula.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        
        // Buscar la persona por cédula en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedula);
        
        // Verificar que la persona existe, es un Administrador y la contraseña coincide
        if (persona instanceof Administrador) {
            Administrador admin = (Administrador) persona;
            if (admin.getPassword().equals(password)) {
                return admin;
            }
        }
        
        return null;
    }
    
    /**
     * Autentica un proveedor en el sistema utilizando cédula y contraseña.
     * 
     * Este método verifica las credenciales del proveedor buscando en el repositorio
     * una persona con la cédula especificada, verificando que sea un Proveedor
     * y comparando la contraseña. Si las credenciales son válidas, devuelve el objeto
     * Proveedor; en caso contrario, devuelve null.
     * 
     * @param cedula   Cédula de identificación del proveedor
     * @param password Contraseña de acceso del proveedor
     * @return El proveedor autenticado o null si las credenciales son inválidas
     */
    @Override
    public Proveedor autenticarProveedor(String cedula, String password) {
        // Validar que los parámetros no sean nulos o vacíos
        if (cedula == null || password == null || cedula.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        
        // Buscar la persona por cédula en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedula);
        
        // Verificar que la persona existe, es un Proveedor y la contraseña coincide
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
     * Este método valida los datos de entrada, verifica que no exista otro usuario
     * con la misma cédula o email, crea un nuevo objeto Usuario y lo almacena
     * en el repositorio. Retorna true si el registro fue exitoso, false en caso contrario.
     * 
     * @param cedula   Cédula de identificación del usuario
     * @param nombre   Nombre completo del usuario
     * @param telefono Número de teléfono del usuario
     * @param password Contraseña de acceso del usuario
     * @param email    Dirección de correo electrónico del usuario
     * @return true si el registro fue exitoso, false en caso contrario
     */
    @Override
    public boolean registrarUsuario(String cedula, String nombre, String telefono, String password, String email) {
        // Validar que todos los datos sean válidos
        if (!validarDatosPersona(cedula, nombre, telefono, password, email)) {
            return false;
        }
        
        // Verificar que no exista otra persona con esa cédula
        if (repositorio.buscarPersonaPorCedula(cedula) != null) {
            return false;
        }
        
        // Verificar que no exista otro usuario con ese email
        if (repositorio.buscarUsuarioPorEmail(email) != null) {
            return false;
        }
        
        // Crear el nuevo usuario con los datos proporcionados
        Usuario nuevoUsuario = new Usuario(cedula, nombre, telefono, password, email);
        
        // Guardar el usuario en el repositorio
        return repositorio.guardarPersona(nuevoUsuario);
    }
    
    /**
     * Registra un nuevo administrador en el sistema.
     * 
     * Este método valida los datos de entrada, verifica que no exista otra persona
     * con la misma cédula, crea un nuevo objeto Administrador y lo almacena
     * en el repositorio. Retorna true si el registro fue exitoso, false en caso contrario.
     * 
     * @param cedula   Cédula de identificación del administrador
     * @param nombre   Nombre completo del administrador
     * @param telefono Número de teléfono del administrador
     * @param password Contraseña de acceso del administrador
     * @param email    Dirección de correo electrónico del administrador
     * @return true si el registro fue exitoso, false en caso contrario
     */
    @Override
    public boolean registrarAdministrador(String cedula, String nombre, String telefono, String password, String email) {
        // Validar que todos los datos sean válidos
        if (!validarDatosPersona(cedula, nombre, telefono, password, email)) {
            return false;
        }
        
        // Verificar que no exista otra persona con esa cédula
        if (repositorio.buscarPersonaPorCedula(cedula) != null) {
            return false;
        }
        
        // Crear el nuevo administrador con los datos proporcionados
        Administrador nuevoAdmin = new Administrador(cedula, nombre, telefono, password, email);
        
        // Guardar el administrador en el repositorio
        return repositorio.guardarPersona(nuevoAdmin);
    }
    
    /**
     * Registra un nuevo proveedor en el sistema.
     * 
     * Este método valida los datos de entrada, verifica que no exista otra persona
     * con la misma cédula, crea un nuevo objeto Proveedor y lo almacena
     * en el repositorio. Retorna true si el registro fue exitoso, false en caso contrario.
     * 
     * @param cedula   Cédula de identificación del proveedor
     * @param nombre   Nombre completo del proveedor
     * @param telefono Número de teléfono del proveedor
     * @param password Contraseña de acceso del proveedor
     * @param email    Dirección de correo electrónico del proveedor
     * @return true si el registro fue exitoso, false en caso contrario
     */
    @Override
    public boolean registrarProveedor(String cedula, String nombre, String telefono, String password, String email) {
        // Validar que todos los datos sean válidos
        if (!validarDatosPersona(cedula, nombre, telefono, password, email)) {
            return false;
        }
        
        // Verificar que no exista otra persona con esa cédula
        if (repositorio.buscarPersonaPorCedula(cedula) != null) {
            return false;
        }
        
        // Crear el nuevo proveedor con los datos proporcionados
        Proveedor nuevoProveedor = new Proveedor(cedula, nombre, telefono, password, email) {
            @Override
            public String getRol() {
                return "Proveedor";
            }
        };
        
        // Guardar el proveedor en el repositorio
        return repositorio.guardarPersona(nuevoProveedor);
    }
    
    // === MÉTODOS DE GESTIÓN DE AMIGOS ===
    
    /**
     * Agrega un amigo a la lista de amigos de un usuario.
     * 
     * Este método busca a ambos usuarios en el repositorio, verifica que existan
     * y que no sean la misma persona, y luego agrega el amigo a la lista del usuario.
     * Retorna true si la operación fue exitosa, false en caso contrario.
     * 
     * @param cedulaUsuarioActual Cédula del usuario que agrega al amigo
     * @param cedulaAmigo         Cédula del usuario a agregar como amigo
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarAmigo(String cedulaUsuarioActual, String cedulaAmigo) {
        // Validar que las cédulas no sean nulas y que no sean la misma persona
        if (cedulaUsuarioActual == null || cedulaAmigo == null || cedulaUsuarioActual.equals(cedulaAmigo)) {
            return false;
        }
        
        // Buscar ambas personas en el repositorio
        Persona personaActual = repositorio.buscarPersonaPorCedula(cedulaUsuarioActual);
        Persona personaAmigo = repositorio.buscarPersonaPorCedula(cedulaAmigo);
        
        // Verificar que ambas personas existen y son usuarios
        if (personaActual instanceof Usuario && personaAmigo instanceof Usuario) {
            Usuario usuarioActual = (Usuario) personaActual;
            Usuario usuarioAmigo = (Usuario) personaAmigo;
            
            // Agregar el amigo a la lista del usuario actual
            return usuarioActual.agregarAmigo(usuarioAmigo);
        }
        
        return false;
    }
    
    /**
     * Elimina un amigo de la lista de amigos de un usuario.
     * 
     * Este método busca a ambos usuarios en el repositorio, verifica que existan
     * y que sean usuarios, y luego elimina el amigo de la lista del usuario.
     * Retorna true si la operación fue exitosa, false en caso contrario.
     * 
     * @param cedulaUsuarioActual Cédula del usuario que elimina al amigo
     * @param cedulaAmigo         Cédula del usuario a eliminar de amigos
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    @Override
    public boolean eliminarAmigo(String cedulaUsuarioActual, String cedulaAmigo) {
        // Validar que las cédulas no sean nulas
        if (cedulaUsuarioActual == null || cedulaAmigo == null) {
            return false;
        }
        
        // Buscar ambas personas en el repositorio
        Persona personaActual = repositorio.buscarPersonaPorCedula(cedulaUsuarioActual);
        Persona personaAmigo = repositorio.buscarPersonaPorCedula(cedulaAmigo);
        
        // Verificar que ambas personas existen y son usuarios
        if (personaActual instanceof Usuario && personaAmigo instanceof Usuario) {
            Usuario usuarioActual = (Usuario) personaActual;
            Usuario usuarioAmigo = (Usuario) personaAmigo;
            
            // Eliminar el amigo de la lista del usuario actual
            return usuarioActual.eliminarAmigo(usuarioAmigo);
        }
        
        return false;
    }
    
    /**
     * Obtiene la lista de amigos de un usuario.
     * 
     * Este método busca al usuario en el repositorio y devuelve su lista de amigos.
     * Si el usuario no existe o no es un Usuario, devuelve una lista vacía.
     * 
     * @param cedulaUsuario Cédula del usuario del cual obtener los amigos
     * @return Lista de amigos del usuario
     */
    @Override
    public List<Usuario> obtenerAmigos(String cedulaUsuario) {
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        
        // Verificar que la persona existe y es un usuario
        if (persona instanceof Usuario) {
            return ((Usuario) persona).getAmigos();
        }
        
        // Devolver lista vacía si no se encuentra el usuario
        return List.of();
    }
    
    // === MÉTODOS DE GESTIÓN DE VEHÍCULOS ===
    
    /**
     * Consulta los vehículos de un usuario específico.
     * 
     * Este método busca al usuario en el repositorio y devuelve su lista de vehículos.
     * Si el usuario no existe o no es un Usuario, devuelve una lista vacía.
     * 
     * @param cedulaUsuario Cédula del usuario del cual obtener los vehículos
     * @return Lista de vehículos del usuario
     */
    @Override
    public List<Vehiculo> consultarVehiculosDeUsuario(String cedulaUsuario) {
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        
        // Verificar que la persona existe y es un usuario
        if (persona instanceof Usuario) {
            return ((Usuario) persona).getVehiculos();
        }
        
        // Devolver lista vacía si no se encuentra el usuario
        return List.of();
    }
    
    /**
     * Agrega un vehículo a la lista de vehículos de un usuario.
     * 
     * Este método busca al usuario en el repositorio, verifica que sea un Usuario,
     * agrega el vehículo a su lista y también lo guarda en el repositorio general.
     * Retorna true si la operación fue exitosa, false en caso contrario.
     * 
     * @param cedulaUsuario Cédula del usuario al cual agregar el vehículo
     * @param vehiculo      Vehículo a asociar con el usuario
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarVehiculoAUsuario(String cedulaUsuario, Vehiculo vehiculo) {
        // Validar que los parámetros no sean nulos
        if (cedulaUsuario == null || vehiculo == null) {
            return false;
        }
        
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        
        // Verificar que la persona existe y es un usuario
        if (persona instanceof Usuario) {
            Usuario usuario = (Usuario) persona;
            
            // Agregar el vehículo a la lista del usuario
            boolean agregado = usuario.agregarVehiculo(vehiculo);
            
            // Si se agregó exitosamente, también guardarlo en el repositorio general
            if (agregado) {
                repositorio.guardarVehiculo(vehiculo);
            }
            
            return agregado;
        }
        
        return false;
    }
    
    /**
     * Elimina un vehículo de la lista de vehículos de un usuario.
     * 
     * Este método busca al usuario en el repositorio, verifica que sea un Usuario,
     * busca el vehículo por ID, lo elimina de la lista del usuario y también
     * lo elimina del repositorio general. Retorna true si la operación fue exitosa.
     * 
     * @param cedulaUsuario Cédula del usuario del cual eliminar el vehículo
     * @param idVehiculo    ID del vehículo a desasociar del usuario
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    @Override
    public boolean eliminarVehiculoDeUsuario(String cedulaUsuario, String idVehiculo) {
        // Validar que los parámetros no sean nulos
        if (cedulaUsuario == null || idVehiculo == null) {
            return false;
        }
        
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaUsuario);
        
        // Verificar que la persona existe y es un usuario
        if (persona instanceof Usuario) {
            Usuario usuario = (Usuario) persona;
            
            // Buscar el vehículo por ID en el repositorio
            Vehiculo vehiculo = repositorio.buscarVehiculoPorId(idVehiculo);
            
            if (vehiculo != null) {
                // Eliminar el vehículo de la lista del usuario
                boolean eliminado = usuario.eliminarVehiculo(vehiculo);
                
                // Si se eliminó exitosamente, también eliminarlo del repositorio general
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
     * Este método valida los datos de entrada, genera un ID único, crea el vehículo
     * según el tipo especificado (Scooter o MotoElectrica) y lo guarda en el repositorio.
     * Retorna el vehículo creado o null si hubo error.
     * 
     * @param marca      Marca comercial del vehículo
     * @param modelo     Modelo específico del vehículo
     * @param autonomiaKm Autonomía en kilómetros del vehículo
     * @param tipo       Tipo de vehículo (Scooter, MotoElectrica)
     * @return El vehículo creado o null si hubo error
     */
    @Override
    public Vehiculo crearVehiculo(String marca, String modelo, int autonomiaKm, String tipo) {
        // Validar que todos los datos sean válidos
        if (marca == null || modelo == null || tipo == null || 
            marca.trim().isEmpty() || modelo.trim().isEmpty() || tipo.trim().isEmpty() ||
            autonomiaKm <= 0) {
            return null;
        }
        
        // Generar un ID único para el vehículo
        String id = generarIdUnico();
        Vehiculo vehiculo = null;
        
        // Crear el vehículo según el tipo especificado
        switch (tipo.toLowerCase()) {
            case "scooter":
                vehiculo = new Scooter(id, marca, modelo, autonomiaKm);
                break;
            case "moto":
            case "moto electrica":
                vehiculo = new MotoElectrica(id, marca, modelo, autonomiaKm);
                break;
            default:
                return null; // Tipo no válido
        }
        
        // Si se creó exitosamente, guardarlo en el repositorio
        if (vehiculo != null) {
            repositorio.guardarVehiculo(vehiculo);
        }
        
        return vehiculo;
    }
    
    // === MÉTODOS DE GESTIÓN DE ITEMS ===
    
    /**
     * Crea un nuevo item en el sistema.
     * 
     * Este método valida los datos de entrada, genera un ID único, crea el item
     * según el tipo especificado (Servicio o Producto) y lo guarda en el repositorio.
     * Retorna el item creado o null si hubo error.
     * 
     * @param nombre      Nombre comercial del item
     * @param descripcion Descripción detallada del item
     * @param tipo        Tipo de item (Servicio, Producto)
     * @return El item creado o null si hubo error
     */
    @Override
    public Item crearItem(String nombre, String descripcion, String tipo) {
        // Validar que todos los datos sean válidos
        if (nombre == null || descripcion == null || tipo == null ||
            nombre.trim().isEmpty() || descripcion.trim().isEmpty() || tipo.trim().isEmpty()) {
            return null;
        }
        
        // Generar un ID único para el item
        String id = generarIdUnico();
        Item item = null;
        
        // Crear el item según el tipo especificado
        switch (tipo.toLowerCase()) {
            case "servicio":
                item = new Servicio(id, nombre, descripcion);
                break;
            case "producto":
                item = new Producto(id, nombre, descripcion);
                break;
            default:
                return null; // Tipo no válido
        }
        
        // Si se creó exitosamente, guardarlo en el repositorio
        if (item != null) {
            repositorio.guardarItem(item);
        }
        
        return item;
    }
    
    /**
     * Agrega un item al catálogo de un proveedor.
     * 
     * Este método busca al proveedor en el repositorio, verifica que sea un Proveedor,
     * y agrega el item a su catálogo. Retorna true si la operación fue exitosa.
     * 
     * @param cedulaProveedor Cédula del proveedor al cual agregar el item
     * @param item           Item a asociar con el proveedor
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarItemAProveedor(String cedulaProveedor, Item item) {
        // Validar que los parámetros no sean nulos
        if (cedulaProveedor == null || item == null) {
            return false;
        }
        
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        
        // Verificar que la persona existe y es un proveedor
        if (persona instanceof Proveedor) {
            Proveedor proveedor = (Proveedor) persona;
            
            // Agregar el item al catálogo del proveedor
            return proveedor.agregarItem(item);
        }
        
        return false;
    }
    
    /**
     * Obtiene los items que ofrece un proveedor.
     * 
     * Este método busca al proveedor en el repositorio y devuelve su catálogo de items.
     * Si el proveedor no existe o no es un Proveedor, devuelve una lista vacía.
     * 
     * @param cedulaProveedor Cédula del proveedor del cual obtener los items
     * @return Lista de items del proveedor
     */
    @Override
    public List<Item> obtenerItemsDeProveedor(String cedulaProveedor) {
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        
        // Verificar que la persona existe y es un proveedor
        if (persona instanceof Proveedor) {
            return ((Proveedor) persona).getItems();
        }
        
        // Devolver lista vacía si no se encuentra el proveedor
        return List.of();
    }
    
    // === MÉTODOS DE GESTIÓN DE PUBLICACIONES ===
    
    /**
     * Crea una nueva publicación en el sistema.
     * 
     * Este método valida los datos de entrada, genera un ID único, crea la publicación
     * y la guarda en el repositorio. Retorna la publicación creada o null si hubo error.
     * 
     * @param titulo       Título descriptivo de la publicación
     * @param descripcion  Descripción detallada de la publicación
     * @param tipo         Tipo de publicación (Evento, Promocion)
     * @return La publicación creada o null si hubo error
     */
    @Override
    public Publicacion crearPublicacion(String titulo, String descripcion, String tipo) {
        // Validar que todos los datos sean válidos
        if (titulo == null || descripcion == null || tipo == null ||
            titulo.trim().isEmpty() || descripcion.trim().isEmpty() || tipo.trim().isEmpty()) {
            return null;
        }
        
        // Generar un ID único para la publicación
        String id = generarIdUnico();
        
        // Obtener la fecha actual como fecha de creación
        String fechaCreacion = java.time.LocalDate.now().toString();
        
        // Crear la publicación con los datos proporcionados
        Publicacion publicacion = new Publicacion(id, titulo, descripcion, fechaCreacion) {
            @Override
            public String getTipo() {
                return tipo;
            }
        };
        
        // Guardar la publicación en el repositorio
        repositorio.guardarPublicacion(publicacion);
        
        return publicacion;
    }
    
    /**
     * Agrega una publicación al perfil de un proveedor.
     * 
     * Este método busca al proveedor en el repositorio, verifica que sea un Proveedor,
     * y agrega la publicación a su perfil. Retorna true si la operación fue exitosa.
     * 
     * @param cedulaProveedor Cédula del proveedor al cual agregar la publicación
     * @param publicacion    Publicación a asociar con el proveedor
     * @return true si se agregó exitosamente, false en caso contrario
     */
    @Override
    public boolean agregarPublicacionAProveedor(String cedulaProveedor, Publicacion publicacion) {
        // Validar que los parámetros no sean nulos
        if (cedulaProveedor == null || publicacion == null) {
            return false;
        }
        
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        
        // Verificar que la persona existe y es un proveedor
        if (persona instanceof Proveedor) {
            Proveedor proveedor = (Proveedor) persona;
            
            // Agregar la publicación al perfil del proveedor
            return proveedor.agregarPublicacion(publicacion);
        }
        
        return false;
    }
    
    /**
     * Obtiene las publicaciones de un proveedor.
     * 
     * Este método busca al proveedor en el repositorio y devuelve sus publicaciones.
     * Si el proveedor no existe o no es un Proveedor, devuelve una lista vacía.
     * 
     * @param cedulaProveedor Cédula del proveedor del cual obtener las publicaciones
     * @return Lista de publicaciones del proveedor
     */
    @Override
    public List<Publicacion> obtenerPublicacionesDeProveedor(String cedulaProveedor) {
        // Buscar la persona en el repositorio
        Persona persona = repositorio.buscarPersonaPorCedula(cedulaProveedor);
        
        // Verificar que la persona existe y es un proveedor
        if (persona instanceof Proveedor) {
            return ((Proveedor) persona).getPublicaciones();
        }
        
        // Devolver lista vacía si no se encuentra el proveedor
        return List.of();
    }
    
    // === MÉTODOS DE CONSULTA GENERAL ===
    
    /**
     * Obtiene todas las personas registradas en el sistema.
     * 
     * Este método devuelve una lista completa de todas las personas
     * (usuarios, administradores y proveedores) registradas en el sistema.
     * 
     * @return Lista de todas las personas del sistema
     */
    @Override
    public List<Persona> obtenerTodasLasPersonas() {
        return repositorio.obtenerTodasLasPersonas();
    }
    
    /**
     * Obtiene todos los vehículos registrados en el sistema.
     * 
     * Este método devuelve una lista completa de todos los vehículos
     * registrados en el sistema.
     * 
     * @return Lista de todos los vehículos del sistema
     */
    @Override
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return repositorio.obtenerTodosLosVehiculos();
    }
    
    /**
     * Obtiene todos los items registrados en el sistema.
     * 
     * Este método devuelve una lista completa de todos los items
     * (servicios y productos) registrados en el sistema.
     * 
     * @return Lista de todos los items del sistema
     */
    @Override
    public List<Item> obtenerTodosLosItems() {
        return repositorio.obtenerTodosLosItems();
    }
    
    /**
     * Obtiene todas las publicaciones registradas en el sistema.
     * 
     * Este método devuelve una lista completa de todas las publicaciones
     * (eventos y promociones) registradas en el sistema.
     * 
     * @return Lista de todas las publicaciones del sistema
     */
    @Override
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return repositorio.obtenerTodasLasPublicaciones();
    }
    
    /**
     * Obtiene estadísticas generales del sistema.
     * 
     * Este método genera un reporte con estadísticas detalladas
     * del sistema, incluyendo número de usuarios, vehículos, items
     * y publicaciones.
     * 
     * @return String con las estadísticas detalladas del sistema
     */
    @Override
    public String obtenerEstadisticasSistema() {
        return repositorio.obtenerEstadisticas();
    }
    
    // === MÉTODOS PRIVADOS DE UTILIDAD ===
    
    /**
     * Valida los datos básicos de una persona.
     * 
     * Este método verifica que todos los datos requeridos para una persona
     * sean válidos: no nulos, no vacíos, y que el email contenga el símbolo @.
     * Es utilizado por los métodos de registro para validar la entrada.
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
     * Este método utiliza UUID para generar identificadores únicos
     * para las entidades del sistema. Toma los primeros 8 caracteres
     * del UUID para mantener IDs más cortos y manejables.
     * 
     * @return ID único generado para la entidad
     */
    private String generarIdUnico() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
