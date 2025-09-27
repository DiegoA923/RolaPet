package com.rolapet.modelo;

/**
 * Clase que representa una Moto Eléctrica en el sistema RolaPet.
 * 
 * Una Moto Eléctrica es un vehículo de dos ruedas con motor eléctrico,
 * diseñada para desplazamientos urbanos y periurbanos.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class MotoElectrica extends Vehiculo {
    
    /**
     * Constructor de la clase MotoElectrica.
     * 
     * @param id         Identificador único del vehículo
     * @param marca      Marca de la moto
     * @param modelo     Modelo de la moto
     * @param autonomiaKm Autonomía en kilómetros
     */
    public MotoElectrica(String id, String marca, String modelo, int autonomiaKm) {
        super(id, marca, modelo, autonomiaKm);
    }
    
    /**
     * Obtiene el tipo de vehículo.
     * 
     * @return El tipo de vehículo
     */
    @Override
    public String getTipo() {
        return "Moto Eléctrica";
    }
    
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
