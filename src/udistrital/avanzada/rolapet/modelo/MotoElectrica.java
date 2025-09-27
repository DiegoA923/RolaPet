package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa una Moto Eléctrica en el sistema RolaPet.
 * 
 * Una Moto Eléctrica es un vehículo de dos ruedas con motor eléctrico,
 * diseñada para desplazamientos urbanos y periurbanos. Ofrece mayor
 * autonomía y velocidad que un scooter, ideal para distancias medias
 * y viajes más largos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class MotoElectrica extends Vehiculo {
    
    /**
     * Constructor de la clase MotoElectrica.
     * 
     * Este constructor crea una nueva moto eléctrica con las
     * características específicas de este tipo de vehículo.
     * 
     * @param id         Identificador único de la moto en el sistema
     * @param marca      Marca comercial de la moto
     * @param modelo     Modelo específico de la moto
     * @param autonomiaKm Autonomía en kilómetros de la moto
     */
    public MotoElectrica(String id, String marca, String modelo, int autonomiaKm) {
        super(id, marca, modelo, autonomiaKm);
    }
    
    /**
     * Obtiene el tipo específico de vehículo.
     * 
     * Este método identifica que este vehículo es una Moto Eléctrica,
     * diferenciándolo de otros tipos de vehículos eléctricos.
     * 
     * @return El tipo "Moto Eléctrica" para este vehículo
     */
    @Override
    public String getTipo() {
        return "Moto Eléctrica";
    }
    
    /**
     * Genera una representación en texto de la moto eléctrica.
     * 
     * Este método crea una cadena de texto que contiene la información
     * específica de la moto eléctrica, incluyendo todos sus datos técnicos.
     * 
     * @return Una cadena con la información completa de la moto eléctrica
     */
    @Override
    public String toString() {
        return "MotoElectrica{" +
                "id='" + getId() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", autonomiaKm=" + getAutonomiaKm() +
                '}';
    }
}