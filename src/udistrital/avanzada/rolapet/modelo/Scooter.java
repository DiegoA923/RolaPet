package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa un Scooter eléctrico en el sistema RolaPet.
 * 
 * Un Scooter es un vehículo eléctrico de dos ruedas, ideal para
 * desplazamientos urbanos cortos y medianos. Tiene características
 * específicas como menor autonomía pero mayor maniobrabilidad
 * en espacios reducidos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Scooter extends Vehiculo {
    
    /**
     * Constructor de la clase Scooter.
     * 
     * Este constructor crea un nuevo scooter eléctrico con las
     * características específicas de este tipo de vehículo.
     * 
     * @param id         Identificador único del scooter en el sistema
     * @param marca      Marca comercial del scooter
     * @param modelo     Modelo específico del scooter
     * @param autonomiaKm Autonomía en kilómetros del scooter
     */
    public Scooter(String id, String marca, String modelo, int autonomiaKm) {
        super(id, marca, modelo, autonomiaKm);
    }
    
    /**
     * Obtiene el tipo específico de vehículo.
     * 
     * Este método identifica que este vehículo es un Scooter,
     * diferenciándolo de otros tipos de vehículos eléctricos.
     * 
     * @return El tipo "Scooter" para este vehículo
     */
    @Override
    public String getTipo() {
        return "Scooter";
    }
    
    /**
     * Genera una representación en texto del scooter.
     * 
     * Este método crea una cadena de texto que contiene la información
     * específica del scooter, incluyendo todos sus datos técnicos.
     * 
     * @return Una cadena con la información completa del scooter
     */
    @Override
    public String toString() {
        return "Scooter{" +
                "id='" + getId() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", autonomiaKm=" + getAutonomiaKm() +
                '}';
    }
}