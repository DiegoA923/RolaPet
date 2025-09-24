package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta que representa un vehículo eléctrico genérico.
 * Define atributos y comportamientos comunes a todos los vehículos.
 *
 * <p>Incluye información general como su identificador único,
 * autonomía en kilómetros, velocidad máxima y marca.</p>
 *
 * @author Diego
 * @version 1.0
 * @date 24/09/2025
 */
public abstract class Vehiculo {
    private String id;          // Identificador único en el sistema
    private int autonomiaKm;    // Kilómetros que puede recorrer con la batería
    private int velocidadMax;   // Velocidad máxima del vehículo
    private String marca;       // Marca del vehículo

    public Vehiculo(String id, int autonomiaKm, int velocidadMax, String marca) {
        this.id = id;
        this.autonomiaKm = autonomiaKm;
        this.velocidadMax = velocidadMax;
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el tipo específico de vehículo (Scooter, Moto eléctrica, etc).
     * @return tipo de vehículo en formato String
     */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "ID: " + id +
               " | Marca: " + marca +
               " | Autonomía: " + autonomiaKm + " km" +
               " | Velocidad Máx: " + velocidadMax + " km/h";
    }
}


