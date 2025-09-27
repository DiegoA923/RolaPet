package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un Usuario dentro del sistema RolaPet.
 * <p>
 * Un Usuario puede registrarse en el sistema, agregar o eliminar vehículos,
 * consultar su información y gestionar su lista de amigos. Esta clase hereda
 * de {@link Persona} y define su rol específico como "Usuario".
 * </p>
 * 
 * <p>
 * Cada Usuario mantiene listas de {@link Vehiculo} y de amigos (otros usuarios),
 * permitiendo gestionar los vehículos propios y relaciones sociales dentro del sistema.
 * </p>
 * 
 * @author Diego
 * @version 1.1
 * @date 23/09/2025
 */

/* Fecha de Modificacion: 24/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001
 * Descripción de la modificación:
 *    Se añadieron listas de vehículos y amigos al Usuario,
 *    con métodos para agregar, eliminar y mostrar.
 */
public class Usuario extends Persona {

    
    private List<Vehiculo> vehiculos; // Lista de vehículos que posee el usuario
    
    private List<Usuario> amigos; //Lista Lista de amigos del usuario

    /**
     * Crea un nuevo Usuario con la información básica.
     * Inicializa las listas de vehículos y amigos.
     * 
     * @param cedula   La cédula del usuario
     * @param nombre   El nombre del usuario
     * @param apellido El apellido del usuario
     * @param telefono El número de teléfono del usuario
     * @param correo   El correo electrónico del usuario
     * @param password La contraseña del usuario
     */
    public Usuario(int cedula, String nombre, String apellido, int telefono, String correo, String password) {
        super(cedula, nombre, apellido, telefono, correo, password);
        this.vehiculos = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    /**
     * Devuelve el rol específico de este usuario.
     * 
     * @return Una cadena indicando que es "Usuario".
     */
    @Override
    public String getRol() {
        return "Usuario";
    }

    /**
     * Agrega un vehículo a la lista de vehículos del usuario.
     * 
     * @param v El vehículo a agregar
     */
    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    /**
     * Elimina un vehículo de la lista de vehículos del usuario.
     * 
     * @param v El vehículo a eliminar
     */
    public void eliminarVehiculo(Vehiculo v) {
        vehiculos.remove(v);
    }

    /**
    * Muestra información de todos los vehículos del usuario.
    */
    public void mostrarVehiculos() {
     for (Vehiculo v : vehiculos) {
            System.out.println(
                "ID: " + v.getId() +
                " | Marca: " + v.getMarca() +
                " | Autonomía: " + v.getAutonomiaKm() + " km" +
                " | Velocidad Máx: " + v.getVelocidadMax() + " km/h"
            );
        }
    }   

    /**
     * Agrega un amigo a la lista de amigos del usuario.
     * 
     * @param u El usuario a agregar como amigo
     */
    public void agregarAmigo(Usuario u) {
        amigos.add(u);
    }

    /**
     * Elimina un amigo de la lista de amigos del usuario.
     * 
     * @param u El usuario a eliminar de la lista de amigos
     */
    public void eliminarAmigo(Usuario u) {
        amigos.remove(u);
    }

    /**
     * Muestra los nombres de todos los amigos del usuario.
     */
    public void mostrarAmigos() {
        for (Usuario a : amigos) {
            System.out.println(a.getNombre());
        }
    }
}