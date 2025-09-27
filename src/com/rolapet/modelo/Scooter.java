package com.rolapet.modelo;

/**
 * Clase que representa un Scooter eléctrico en el sistema RolaPet.
 * 
 * Un Scooter es un vehículo eléctrico de dos ruedas, ideal para
 * desplazamientos urbanos cortos y medianos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Scooter extends Vehiculo {
    
    /**
     * Constructor de la clase Scooter.
     * 
     * @param id         Identificador único del vehículo
     * @param marca      Marca del scooter
     * @param modelo     Modelo del scooter
     * @param autonomiaKm Autonomía en kilómetros
     */
    public Scooter(String id, String marca, String modelo, int autonomiaKm) {
        super(id, marca, modelo, autonomiaKm);
    }
    
    /**
     * Obtiene el tipo de vehículo.
     * 
     * @return El tipo de vehículo
     */
    @Override
    public String getTipo() {
        return "Scooter";
    }
    
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
