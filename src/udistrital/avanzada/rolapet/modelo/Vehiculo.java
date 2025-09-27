package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta que representa un vehículo en el sistema RolaPet.
 * 
 * Esta clase define los atributos y comportamientos comunes a todos
 * los tipos de vehículos eléctricos del sistema. Actúa como la clase
 * base para la jerarquía de vehículos, permitiendo la extensión
 * para diferentes tipos específicos de vehículos eléctricos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Vehiculo {
    
    /** Identificador único del vehículo en el sistema */
    private String id;
    
    /** Marca comercial del vehículo */
    private String marca;
    
    /** Modelo específico del vehículo */
    private String modelo;
    
    /** Autonomía en kilómetros que puede recorrer el vehículo con una carga completa */
    private int autonomiaKm;
    
    /**
     * Constructor de la clase Vehiculo.
     * 
     * Este constructor inicializa un nuevo vehículo con los datos
     * básicos proporcionados. Es llamado por las clases hijas para
     * establecer la información fundamental de cualquier vehículo.
     * 
     * @param id         Identificador único del vehículo en el sistema
     * @param marca      Marca comercial del vehículo
     * @param modelo     Modelo específico del vehículo
     * @param autonomiaKm Autonomía en kilómetros con una carga completa
     */
    public Vehiculo(String id, String marca, String modelo, int autonomiaKm) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.autonomiaKm = autonomiaKm;
    }
    
    /**
     * Obtiene el identificador único del vehículo.
     * 
     * Este método devuelve el ID que identifica únicamente
     * a este vehículo en el sistema.
     * 
     * @return El identificador único del vehículo
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el identificador único del vehículo.
     * 
     * Este método permite modificar el ID del vehículo,
     * útil para correcciones o reorganización de datos.
     * 
     * @param id El nuevo identificador único del vehículo
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene la marca comercial del vehículo.
     * 
     * Este método devuelve la marca que fabricó el vehículo,
     * como Tesla, BMW, Nissan, etc.
     * 
     * @return La marca comercial del vehículo
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Establece la marca comercial del vehículo.
     * 
     * Este método permite actualizar la marca del vehículo
     * en caso de correcciones de datos.
     * 
     * @param marca La nueva marca comercial del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene el modelo específico del vehículo.
     * 
     * Este método devuelve el modelo específico del vehículo,
     * que junto con la marca identifica el vehículo.
     * 
     * @return El modelo específico del vehículo
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Establece el modelo específico del vehículo.
     * 
     * Este método permite actualizar el modelo del vehículo
     * en caso de correcciones de datos.
     * 
     * @param modelo El nuevo modelo específico del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Obtiene la autonomía del vehículo en kilómetros.
     * 
     * Este método devuelve la distancia máxima que puede recorrer
     * el vehículo con una carga completa de batería.
     * 
     * @return La autonomía en kilómetros del vehículo
     */
    public int getAutonomiaKm() {
        return autonomiaKm;
    }
    
    /**
     * Establece la autonomía del vehículo en kilómetros.
     * 
     * Este método permite actualizar la autonomía del vehículo
     * en caso de correcciones o actualizaciones de datos.
     * 
     * @param autonomiaKm La nueva autonomía en kilómetros del vehículo
     */
    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }
    
    /**
     * Método abstracto para obtener el tipo específico de vehículo.
     * 
     * Este método debe ser implementado por cada clase hija para
     * devolver el tipo específico de vehículo (Scooter, Moto Eléctrica, etc.).
     * Permite identificar y categorizar diferentes tipos de vehículos.
     * 
     * @return El tipo específico de vehículo
     */
    public abstract String getTipo();
    
    /**
     * Genera una representación en texto del vehículo.
     * 
     * Este método crea una cadena de texto que contiene la información
     * completa del vehículo, incluyendo ID, marca, modelo, autonomía y tipo.
     * Es útil para mostrar información del vehículo en la interfaz.
     * 
     * @return Una cadena con la información completa del vehículo
     */
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", autonomiaKm=" + autonomiaKm +
                ", tipo='" + getTipo() + '\'' +
                '}';
    }
    
    /**
     * Compara si dos vehículos son iguales basándose en su ID.
     * 
     * Este método permite determinar si dos objetos Vehiculo representan
     * al mismo vehículo comparando sus identificadores únicos.
     * 
     * @param obj El objeto a comparar
     * @return true si los vehículos tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return id != null ? id.equals(vehiculo.id) : vehiculo.id == null;
    }
    
    /**
     * Genera un código hash basado en el ID del vehículo.
     * 
     * Este método es utilizado por las estructuras de datos como HashMap
     * para organizar y buscar objetos Vehiculo de manera eficiente.
     * 
     * @return El código hash del vehículo basado en su ID
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}