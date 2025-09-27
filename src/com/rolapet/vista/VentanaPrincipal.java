package com.rolapet.vista;

import com.rolapet.controlador.IControladorRolaPET;
import com.rolapet.controlador.ControladorRolaPET;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del sistema RolaPet.
 * 
 * Esta clase gestiona la interfaz gráfica principal y coordina
 * la navegación entre diferentes paneles del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class VentanaPrincipal extends JFrame {
    
    /** Controlador del sistema */
    private final IControladorRolaPET controlador;
    
    /** Panel de contenido principal */
    private JPanel panelContenido;
    
    /** Panel de login */
    private PanelLogin panelLogin;
    
    /** Panel de registro */
    private PanelRegistro panelRegistro;
    
    /** Panel de dashboard del usuario */
    private PanelDashboardUsuario panelDashboardUsuario;
    
    /**
     * Constructor de la ventana principal.
     */
    public VentanaPrincipal() {
        this.controlador = new ControladorRolaPET();
        inicializarComponentes();
        configurarVentana();
        mostrarPanelLogin();
    }
    
    /**
     * Inicializa todos los componentes de la interfaz.
     */
    private void inicializarComponentes() {
        // Crear el panel de contenido principal
        panelContenido = new JPanel(new CardLayout());
        
        // Crear los paneles específicos
        panelLogin = new PanelLogin(this);
        panelRegistro = new PanelRegistro(this);
        panelDashboardUsuario = new PanelDashboardUsuario(this);
        
        // Agregar paneles al contenedor principal
        panelContenido.add(panelLogin, "LOGIN");
        panelContenido.add(panelRegistro, "REGISTRO");
        panelContenido.add(panelDashboardUsuario, "DASHBOARD");
    }
    
    /**
     * Configura las propiedades de la ventana principal.
     */
    private void configurarVentana() {
        setTitle("RolaPet - Sistema de Gestión de Vehículos Eléctricos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Agregar el panel de contenido a la ventana
        add(panelContenido, BorderLayout.CENTER);
        
        // Configurar el menú
        configurarMenu();
    }
    
    /**
     * Configura la barra de menú de la aplicación.
     */
    private void configurarMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(itemSalir);
        
        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcerca = new JMenuItem("Acerca de");
        itemAcerca.addActionListener(e -> mostrarAcercaDe());
        menuAyuda.add(itemAcerca);
        
        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);
        
        setJMenuBar(menuBar);
    }
    
    /**
     * Muestra el panel de login.
     */
    public void mostrarPanelLogin() {
        CardLayout layout = (CardLayout) panelContenido.getLayout();
        layout.show(panelContenido, "LOGIN");
    }
    
    /**
     * Muestra el panel de registro.
     */
    public void mostrarPanelRegistro() {
        CardLayout layout = (CardLayout) panelContenido.getLayout();
        layout.show(panelContenido, "REGISTRO");
    }
    
    /**
     * Muestra el panel de dashboard del usuario.
     */
    public void mostrarPanelDashboard() {
        CardLayout layout = (CardLayout) panelContenido.getLayout();
        layout.show(panelContenido, "DASHBOARD");
    }
    
    /**
     * Obtiene el controlador del sistema.
     * 
     * @return El controlador del sistema
     */
    public IControladorRolaPET getControlador() {
        return controlador;
    }
    
    /**
     * Muestra un diálogo de información.
     * 
     * @param mensaje El mensaje a mostrar
     * @param titulo  El título del diálogo
     */
    public void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra un diálogo de error.
     * 
     * @param mensaje El mensaje de error a mostrar
     * @param titulo  El título del diálogo
     */
    public void mostrarError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra un diálogo de confirmación.
     * 
     * @param mensaje El mensaje a mostrar
     * @param titulo  El título del diálogo
     * @return true si el usuario confirma, false en caso contrario
     */
    public boolean mostrarConfirmacion(String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(this, mensaje, titulo, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return respuesta == JOptionPane.YES_OPTION;
    }
    
    /**
     * Muestra el diálogo "Acerca de".
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
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Configurar el look and feel del sistema
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
