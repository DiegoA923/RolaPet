package com.rolapet.modelo;

/**
 * Clase abstracta que representa un vehículo en el sistema RolaPet.
 * 
 * Esta clase define los atributos y comportamientos comunes a todos
 * los tipos de vehículos eléctricos del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public abstract class Vehiculo {
    
    /** Identificador único del vehículo */
    private String id;
    
    /** Marca del vehículo */
    private String marca;
    
    /** Modelo del vehículo */
    private String modelo;
    
    /** Autonomía en kilómetros del vehículo */
    private int autonomiaKm;
    
    /**
     * Constructor de la clase Vehiculo.
     * 
     * @param id         Identificador único del vehículo
     * @param marca      Marca del vehículo
     * @param modelo     Modelo del vehículo
     * @param autonomiaKm Autonomía en kilómetros
     */
    public Vehiculo(String id, String marca, String modelo, int autonomiaKm) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.autonomiaKm = autonomiaKm;
    }
    
    /**
     * Obtiene el identificador del vehículo.
     * 
     * @return El identificador del vehículo
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el identificador del vehículo.
     * 
     * @param id El identificador del vehículo
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene la marca del vehículo.
     * 
     * @return La marca del vehículo
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Establece la marca del vehículo.
     * 
     * @param marca La marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return El modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo El modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Obtiene la autonomía del vehículo.
     * 
     * @return La autonomía en kilómetros
     */
    public int getAutonomiaKm() {
        return autonomiaKm;
    }
    
    /**
     * Establece la autonomía del vehículo.
     * 
     * @param autonomiaKm La autonomía en kilómetros
     */
    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }
    
    /**
     * Método abstracto que debe ser implementado por las clases hijas
     * para obtener el tipo específico de vehículo.
     * 
     * @return El tipo de vehículo
     */
    public abstract String getTipo();
    
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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return id != null ? id.equals(vehiculo.id) : vehiculo.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
