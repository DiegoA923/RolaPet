package udistrital.avanzada.rolapet.controlador;

import udistrital.avanzada.rolapet.controlador.ControladorRolaPET;
import udistrital.avanzada.rolapet.vista.VentanaPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Clase principal (Launcher) del sistema RolaPet.
 * 
 * Esta clase actúa como el punto de entrada de la aplicación, siguiendo
 * los principios SOLID al separar la responsabilidad de inicialización
 * de la lógica de presentación. El Launcher se encarga de:
 * - Instanciar el controlador principal
 * - Configurar el look and feel del sistema
 * - Inicializar la ventana principal
 * - Coordinar el inicio de la aplicación
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class Launcher {
    
    /**
     * Método principal para ejecutar la aplicación RolaPet.
     * 
     * Este método es el punto de entrada de la aplicación. Sigue los principios
     * SOLID al separar las responsabilidades:
     * - Single Responsibility: Solo se encarga de la inicialización
     * - Open/Closed: Extensible para futuras configuraciones
     * - Dependency Inversion: Depende de abstracciones (interfaces)
     * 
     * @param args Argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar el look and feel del sistema operativo
        configurarLookAndFeel();
        
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Crear el controlador principal
                ControladorRolaPET controlador = new ControladorRolaPET();
                
                // Crear la ventana principal pasando el controlador
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(controlador);
                
                // Hacer visible la ventana principal
                ventanaPrincipal.setVisible(true);
                
            } catch (Exception e) {
                // Manejar errores de inicialización
                System.err.println("Error al inicializar la aplicación: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
        });
    }
    
    /**
     * Configura el look and feel del sistema operativo.
     * 
     * Este método establece la apariencia visual de la aplicación
     * para que coincida con el sistema operativo del usuario,
     * proporcionando una experiencia más nativa e integrada.
     */
    private static void configurarLookAndFeel() {
    try {
        // Configurar el look and feel del sistema operativo
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
        // Si no se puede configurar el look and feel, usar el por defecto
        System.err.println("No se pudo configurar el look and feel del sistema: " + e.getMessage());
    }
}

}
