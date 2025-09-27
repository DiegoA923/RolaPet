package com.rolapet.vista;

import com.rolapet.controlador.IControladorRolaPET;
import com.rolapet.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel de login del sistema RolaPet.
 * 
 * Este panel permite a los usuarios autenticarse en el sistema
 * con sus credenciales (email/contraseña para usuarios, cédula/contraseña para otros).
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class PanelLogin extends JPanel {
    
    /** Referencia a la ventana principal */
    private final VentanaPrincipal ventanaPrincipal;
    
    /** Campo de texto para email/cédula */
    private JTextField campoCredencial;
    
    /** Campo de texto para contraseña */
    private JPasswordField campoPassword;
    
    /** Combo box para seleccionar tipo de usuario */
    private JComboBox<String> comboBoxTipoUsuario;
    
    /** Botón de login */
    private JButton botonLogin;
    
    /** Botón de registro */
    private JButton botonRegistro;
    
    /**
     * Constructor del panel de login.
     * 
     * @param ventanaPrincipal Referencia a la ventana principal
     */
    public PanelLogin(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    /**
     * Inicializa todos los componentes del panel.
     */
    private void inicializarComponentes() {
        // Crear etiquetas
        JLabel etiquetaTitulo = new JLabel("Iniciar Sesión - RolaPet");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel etiquetaTipoUsuario = new JLabel("Tipo de Usuario:");
        JLabel etiquetaCredencial = new JLabel("Email/Cédula:");
        JLabel etiquetaPassword = new JLabel("Contraseña:");
        
        // Crear campos de entrada
        comboBoxTipoUsuario = new JComboBox<>(new String[]{"Usuario", "Administrador", "Proveedor"});
        campoCredencial = new JTextField(20);
        campoPassword = new JPasswordField(20);
        
        // Crear botones
        botonLogin = new JButton("Iniciar Sesión");
        botonRegistro = new JButton("Registrarse");
        
        // Configurar propiedades de los componentes
        campoCredencial.setToolTipText("Ingrese su email (usuarios) o cédula (administradores/proveedores)");
        campoPassword.setToolTipText("Ingrese su contraseña");
        botonLogin.setPreferredSize(new Dimension(120, 30));
        botonRegistro.setPreferredSize(new Dimension(120, 30));
    }
    
    /**
     * Configura el layout del panel.
     */
    private void configurarLayout() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel principal con GridBagLayout
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Título
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        panelPrincipal.add(new JLabel("Iniciar Sesión - RolaPet"), gbc);
        
        // Tipo de usuario
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 5, 10);
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Tipo de Usuario:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(comboBoxTipoUsuario, gbc);
        
        // Credencial
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Email/Cédula:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoCredencial, gbc);
        
        // Contraseña
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoPassword, gbc);
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonLogin);
        panelBotones.add(botonRegistro);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);
        
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    /**
     * Configura los eventos de los componentes.
     */
    private void configurarEventos() {
        // Evento del botón de login
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        
        // Evento del botón de registro
        botonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanelRegistro();
            }
        });
        
        // Evento de Enter en los campos de texto
        campoCredencial.addActionListener(e -> realizarLogin());
        campoPassword.addActionListener(e -> realizarLogin());
        
        // Evento de cambio en el combo box
        comboBoxTipoUsuario.addActionListener(e -> actualizarEtiquetaCredencial());
    }
    
    /**
     * Realiza el proceso de login.
     */
    private void realizarLogin() {
        String credencial = campoCredencial.getText().trim();
        String password = new String(campoPassword.getPassword());
        String tipoUsuario = (String) comboBoxTipoUsuario.getSelectedItem();
        
        // Validar campos vacíos
        if (credencial.isEmpty() || password.isEmpty()) {
            ventanaPrincipal.mostrarError("Por favor, complete todos los campos.", "Error de Validación");
            return;
        }
        
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        
        try {
            switch (tipoUsuario) {
                case "Usuario":
                    Usuario usuario = controlador.autenticarUsuario(credencial, password);
                    if (usuario != null) {
                        ventanaPrincipal.mostrarMensaje("¡Bienvenido " + usuario.getNombre() + "!", "Login Exitoso");
                        ventanaPrincipal.mostrarPanelDashboard();
                        limpiarCampos();
                    } else {
                        ventanaPrincipal.mostrarError("Credenciales inválidas para usuario.", "Error de Autenticación");
                    }
                    break;
                    
                case "Administrador":
                    Administrador admin = controlador.autenticarAdministrador(credencial, password);
                    if (admin != null) {
                        ventanaPrincipal.mostrarMensaje("¡Bienvenido Administrador " + admin.getNombre() + "!", "Login Exitoso");
                        ventanaPrincipal.mostrarPanelDashboard();
                        limpiarCampos();
                    } else {
                        ventanaPrincipal.mostrarError("Credenciales inválidas para administrador.", "Error de Autenticación");
                    }
                    break;
                    
                case "Proveedor":
                    Proveedor proveedor = controlador.autenticarProveedor(credencial, password);
                    if (proveedor != null) {
                        ventanaPrincipal.mostrarMensaje("¡Bienvenido Proveedor " + proveedor.getNombre() + "!", "Login Exitoso");
                        ventanaPrincipal.mostrarPanelDashboard();
                        limpiarCampos();
                    } else {
                        ventanaPrincipal.mostrarError("Credenciales inválidas para proveedor.", "Error de Autenticación");
                    }
                    break;
            }
        } catch (Exception ex) {
            ventanaPrincipal.mostrarError("Error durante el proceso de autenticación: " + ex.getMessage(), "Error del Sistema");
        }
    }
    
    /**
     * Actualiza la etiqueta de credencial según el tipo de usuario seleccionado.
     */
    private void actualizarEtiquetaCredencial() {
        String tipoUsuario = (String) comboBoxTipoUsuario.getSelectedItem();
        if ("Usuario".equals(tipoUsuario)) {
            campoCredencial.setToolTipText("Ingrese su email");
        } else {
            campoCredencial.setToolTipText("Ingrese su cédula");
        }
    }
    
    /**
     * Limpia los campos de entrada.
     */
    private void limpiarCampos() {
        campoCredencial.setText("");
        campoPassword.setText("");
        campoCredencial.requestFocus();
    }
}
