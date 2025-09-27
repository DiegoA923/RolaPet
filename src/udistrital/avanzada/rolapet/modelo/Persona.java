package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta que representa a una persona dentro del sistema RolaPet.
 * 
 * Esta clase define los atributos y comportamientos comunes a todos los tipos
 * de personas en el sistema (Usuario, Administrador, Proveedor), siguiendo
 * el principio de sustitución de Liskov. Actúa como la clase base para la
 * jerarquía de personas en el sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Persona {
    
    /** Cédula de identificación única de la persona */
    protected String cedula;
    
    /** Nombre completo de la persona */
    protected String nombre;
    
    /** Número de teléfono de contacto de la persona */
    protected String telefono;
    
    /** Contraseña para autenticación en el sistema */
    protected String password;
    
    /**
     * Constructor de la clase Persona.
     * 
     * Este constructor inicializa una nueva persona con los datos básicos
     * proporcionados. Es llamado por las clases hijas para establecer
     * la información fundamental de cualquier persona en el sistema.
     * 
     * @param cedula   Cédula de identificación única de la persona
     * @param nombre   Nombre completo de la persona
     * @param telefono Número de teléfono de contacto
     * @param password Contraseña para acceso al sistema
     */
    public Persona(String cedula, String nombre, String telefono, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.password = password;
    }
    
    /**
     * Obtiene la cédula de identificación de la persona.
     * 
     * Este método permite acceder al número de cédula que identifica
     * únicamente a cada persona en el sistema.
     * 
     * @return La cédula de identificación de la persona
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Establece la cédula de identificación de la persona.
     * 
     * Este método permite modificar la cédula de identificación
     * de una persona, útil para correcciones de datos.
     * 
     * @param cedula La nueva cédula de identificación
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Obtiene el nombre completo de la persona.
     * 
     * Este método devuelve el nombre completo de la persona
     * tal como fue registrado en el sistema.
     * 
     * @return El nombre completo de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre completo de la persona.
     * 
     * Este método permite actualizar el nombre de una persona
     * en caso de cambios o correcciones.
     * 
     * @param nombre El nuevo nombre completo de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el número de teléfono de la persona.
     * 
     * Este método devuelve el número de teléfono registrado
     * para contacto con la persona.
     * 
     * @return El número de teléfono de la persona
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Establece el número de teléfono de la persona.
     * 
     * Este método permite actualizar el número de teléfono
     * de contacto de la persona.
     * 
     * @param telefono El nuevo número de teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Obtiene la contraseña de acceso de la persona.
     * 
     * Este método devuelve la contraseña utilizada para
     * autenticar a la persona en el sistema.
     * 
     * @return La contraseña de acceso de la persona
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Establece la contraseña de acceso de la persona.
     * 
     * Este método permite cambiar la contraseña de acceso
     * de la persona al sistema.
     * 
     * @param password La nueva contraseña de acceso
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Método abstracto para obtener el rol específico de la persona.
     * 
     * Este método debe ser implementado por cada clase hija para
     * devolver el rol específico que desempeña la persona en el sistema.
     * Permite identificar el tipo de usuario (Usuario, Administrador, Proveedor).
     * 
     * @return El rol específico de la persona en el sistema
     */
    public abstract String getRol();
    
    /**
     * Método abstracto para obtener el email de la persona.
     * 
     * Este método debe ser implementado por cada clase hija para
     * devolver la dirección de correo electrónico de la persona.
     * 
     * @return La dirección de email de la persona
     */
    public abstract String getEmail();
    
    /**
     * Genera una representación en texto de la persona.
     * 
     * Este método crea una cadena de texto que contiene la información
     * básica de la persona, incluyendo cédula, nombre, teléfono y rol.
     * Es útil para mostrar información de la persona en la interfaz.
     * 
     * @return Una cadena con la información básica de la persona
     */
    @Override
    public String toString() {
        return "Persona{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol='" + getRol() + '\'' +
                '}';
    }
    
    /**
     * Compara si dos personas son iguales basándose en su cédula.
     * 
     * Este método permite determinar si dos objetos Persona representan
     * a la misma persona comparando sus cédulas de identificación.
     * 
     * @param obj El objeto a comparar
     * @return true si las personas tienen la misma cédula, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return cedula != null ? cedula.equals(persona.cedula) : persona.cedula == null;
    }
    
    /**
     * Genera un código hash basado en la cédula de la persona.
     * 
     * Este método es utilizado por las estructuras de datos como HashMap
     * para organizar y buscar objetos Persona de manera eficiente.
     * 
     * @return El código hash de la persona basado en su cédula
     */
    @Override
    public int hashCode() {
        return cedula != null ? cedula.hashCode() : 0;
    }
}