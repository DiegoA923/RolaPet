package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.controlador.IControladorRolaPET;
import udistrital.avanzada.rolapet.controlador.ControladorRolaPET;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del sistema RolaPet.
 * 
 * Esta clase gestiona la interfaz gráfica principal y coordina
 * la navegación entre diferentes paneles del sistema. Actúa como
 * el contenedor principal que organiza y muestra los diferentes
 * componentes de la interfaz de usuario según el estado de la aplicación.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class VentanaPrincipal extends JFrame {
    
    /** Controlador del sistema para gestionar la lógica de negocio */
    private final IControladorRolaPET controlador;
    
    /** Panel de contenido principal que contiene todos los paneles */
    private JPanel panelContenido;
    
    /** Panel de login para autenticación de usuarios */
    private PanelLogin panelLogin;
    
    /** Panel de registro para nuevos usuarios */
    private PanelRegistro panelRegistro;
    
    /** Panel de dashboard para usuarios autenticados */
    private PanelDashboardUsuario panelDashboardUsuario;
    
    /**
     * Constructor de la ventana principal.
     * 
     * Este constructor inicializa la ventana principal del sistema,
     * creando el controlador, configurando los componentes de la interfaz
     * y estableciendo la configuración inicial de la ventana.
     */
    public VentanaPrincipal() {
        this.controlador = new ControladorRolaPET();
        inicializarComponentes();
        configurarVentana();
        mostrarPanelLogin();
    }
    
    /**
     * Inicializa todos los componentes de la interfaz.
     * 
     * Este método crea y configura todos los paneles de la aplicación,
     * organizándolos en un sistema de tarjetas (CardLayout) para permitir
     * la navegación entre diferentes vistas del sistema.
     */
    private void inicializarComponentes() {
        // Crear el panel de contenido principal con CardLayout
        panelContenido = new JPanel(new CardLayout());
        
        // Crear los paneles específicos de la aplicación
        panelLogin = new PanelLogin(this);
        panelRegistro = new PanelRegistro(this);
        panelDashboardUsuario = new PanelDashboardUsuario(this);
        
        // Agregar todos los paneles al contenedor principal con identificadores únicos
        panelContenido.add(panelLogin, "LOGIN");
        panelContenido.add(panelRegistro, "REGISTRO");
        panelContenido.add(panelDashboardUsuario, "DASHBOARD");
    }
    
    /**
     * Configura las propiedades de la ventana principal.
     * 
     * Este método establece las propiedades básicas de la ventana,
     * como título, tamaño, posición, comportamiento de cierre y
     * configuración del menú principal de la aplicación.
     */
    private void configurarVentana() {
        // Establecer el título de la ventana
        setTitle("RolaPet - Sistema de Gestión de Vehículos Eléctricos");
        
        // Configurar el comportamiento de cierre de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Establecer el tamaño inicial de la ventana
        setSize(800, 600);
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        
        // Permitir redimensionar la ventana
        setResizable(true);
        
        // Agregar el panel de contenido a la ventana
        add(panelContenido, BorderLayout.CENTER);
        
        // Configurar la barra de menú de la aplicación
        configurarMenu();
    }
    
    /**
     * Configura la barra de menú de la aplicación.
     * 
     * Este método crea y configura la barra de menú principal con
     * opciones de archivo y ayuda, proporcionando acceso a funciones
     * básicas de la aplicación como salir y mostrar información.
     */
    private void configurarMenu() {
        // Crear la barra de menú principal
        JMenuBar menuBar = new JMenuBar();
        
        // Crear el menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemSalir = new JMenuItem("Salir");
        
        // Configurar la acción de salir
        itemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(itemSalir);
        
        // Crear el menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcerca = new JMenuItem("Acerca de");
        
        // Configurar la acción de mostrar información
        itemAcerca.addActionListener(e -> mostrarAcercaDe());
        menuAyuda.add(itemAcerca);
        
        // Agregar los menús a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);
        
        // Establecer la barra de menú en la ventana
        setJMenuBar(menuBar);
    }
    
    /**
     * Muestra el panel de login en la ventana principal.
     * 
     * Este método cambia la vista actual al panel de login,
     * permitiendo a los usuarios autenticarse en el sistema.
     */
    public void mostrarPanelLogin() {
        CardLayout layout = (CardLayout) panelContenido.getLayout();
        layout.show(panelContenido, "LOGIN");
    }
    
    /**
     * Muestra el panel de registro en la ventana principal.
     * 
     * Este método cambia la vista actual al panel de registro,
     * permitiendo a nuevos usuarios registrarse en el sistema.
     */
    public void mostrarPanelRegistro() {
        CardLayout layout = (CardLayout) panelContenido.getLayout();
        layout.show(panelContenido, "REGISTRO");
    }
    
    /**
     * Muestra el panel de dashboard en la ventana principal.
     * 
     * Este método cambia la vista actual al panel de dashboard,
     * mostrando las funcionalidades principales para usuarios autenticados.
     */
    public void mostrarPanelDashboard() {
        CardLayout layout = (CardLayout) panelContenido.getLayout();
        layout.show(panelContenido, "DASHBOARD");
    }
    
    /**
     * Obtiene el controlador del sistema.
     * 
     * Este método devuelve la instancia del controlador que gestiona
     * toda la lógica de negocio del sistema, permitiendo a los paneles
     * acceder a las funcionalidades del sistema.
     * 
     * @return El controlador del sistema
     */
    public IControladorRolaPET getControlador() {
        return controlador;
    }
    
    /**
     * Muestra un diálogo de información al usuario.
     * 
     * Este método muestra un mensaje informativo al usuario en un diálogo
     * modal, útil para confirmar operaciones exitosas o mostrar información
     * importante del sistema.
     * 
     * @param mensaje El mensaje a mostrar al usuario
     * @param titulo  El título del diálogo
     */
    public void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra un diálogo de error al usuario.
     * 
     * Este método muestra un mensaje de error al usuario en un diálogo
     * modal, útil para informar sobre problemas o validaciones fallidas
     * en el sistema.
     * 
     * @param mensaje El mensaje de error a mostrar al usuario
     * @param titulo  El título del diálogo
     */
    public void mostrarError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra un diálogo de confirmación al usuario.
     * 
     * Este método muestra un mensaje de confirmación al usuario en un diálogo
     * modal con opciones de Sí/No, útil para confirmar operaciones importantes
     * o destructivas antes de ejecutarlas.
     * 
     * @param mensaje El mensaje de confirmación a mostrar al usuario
     * @param titulo  El título del diálogo
     * @return true si el usuario confirma la acción, false en caso contrario
     */
    public boolean mostrarConfirmacion(String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(this, mensaje, titulo, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return respuesta == JOptionPane.YES_OPTION;
    }
    
    /**
     * Muestra el diálogo "Acerca de" con información del sistema.
     * 
     * Este método muestra información detallada sobre el sistema RolaPet,
     * incluyendo versión, desarrolladores y derechos de autor.
     */
    private void mostrarAcercaDe() {
        String mensaje = "RolaPet v1.0\n\n" +
                        "Sistema de Gestión de Vehículos Eléctricos\n" +
                        "Desarrollado por el Equipo RolaPet\n\n" +
                        "© 2025 - Todos los derechos reservados";
        JOptionPane.showMessageDialog(this, mensaje, "Acerca de RolaPet", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Método principal para ejecutar la aplicación.
     * 
     * Este método es el punto de entrada de la aplicación. Configura
     * el look and feel del sistema, crea la ventana principal y la
     * hace visible al usuario. Utiliza SwingUtilities.invokeLater
     * para asegurar que la interfaz se ejecute en el hilo de eventos.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar el look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            // Si no se puede configurar el look and feel, usar el por defecto
        }
        
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
