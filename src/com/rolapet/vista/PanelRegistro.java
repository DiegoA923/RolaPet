package com.rolapet.vista;

import com.rolapet.controlador.IControladorRolaPET;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel de registro del sistema RolaPet.
 * 
 * Este panel permite a los usuarios registrarse en el sistema
 * proporcionando sus datos personales y credenciales.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class PanelRegistro extends JPanel {
    
    /** Referencia a la ventana principal */
    private final VentanaPrincipal ventanaPrincipal;
    
    /** Campos de entrada */
    private JTextField campoCedula;
    private JTextField campoNombre;
    private JTextField campoTelefono;
    private JTextField campoEmail;
    private JPasswordField campoPassword;
    private JPasswordField campoConfirmarPassword;
    private JComboBox<String> comboBoxTipoUsuario;
    
    /** Botones */
    private JButton botonRegistrar;
    private JButton botonCancelar;
    
    /**
     * Constructor del panel de registro.
     * 
     * @param ventanaPrincipal Referencia a la ventana principal
     */
    public PanelRegistro(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    /**
     * Inicializa todos los componentes del panel.
     */
    private void inicializarComponentes() {
        // Crear campos de entrada
        campoCedula = new JTextField(20);
        campoNombre = new JTextField(20);
        campoTelefono = new JTextField(20);
        campoEmail = new JTextField(20);
        campoPassword = new JPasswordField(20);
        campoConfirmarPassword = new JPasswordField(20);
        comboBoxTipoUsuario = new JComboBox<>(new String[]{"Usuario", "Administrador", "Proveedor"});
        
        // Crear botones
        botonRegistrar = new JButton("Registrar");
        botonCancelar = new JButton("Cancelar");
        
        // Configurar propiedades
        botonRegistrar.setPreferredSize(new Dimension(120, 30));
        botonCancelar.setPreferredSize(new Dimension(120, 30));
        
        // Configurar tooltips
        campoCedula.setToolTipText("Ingrese su número de cédula");
        campoNombre.setToolTipText("Ingrese su nombre completo");
        campoTelefono.setToolTipText("Ingrese su número de teléfono");
        campoEmail.setToolTipText("Ingrese su dirección de email");
        campoPassword.setToolTipText("Ingrese una contraseña segura");
        campoConfirmarPassword.setToolTipText("Confirme su contraseña");
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
        JLabel etiquetaTitulo = new JLabel("Registro de Usuario - RolaPet");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        panelPrincipal.add(etiquetaTitulo, gbc);
        
        // Tipo de usuario
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 5, 10);
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Tipo de Usuario:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(comboBoxTipoUsuario, gbc);
        
        // Cédula
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Cédula:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoCedula, gbc);
        
        // Nombre
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoNombre, gbc);
        
        // Teléfono
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Teléfono:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoTelefono, gbc);
        
        // Email
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoEmail, gbc);
        
        // Contraseña
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoPassword, gbc);
        
        // Confirmar contraseña
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Confirmar Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoConfirmarPassword, gbc);
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonCancelar);
        
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);
        
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    /**
     * Configura los eventos de los componentes.
     */
    private void configurarEventos() {
        // Evento del botón registrar
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarRegistro();
            }
        });
        
        // Evento del botón cancelar
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanelLogin();
            }
        });
        
        // Evento de Enter en los campos de texto
        campoCedula.addActionListener(e -> campoNombre.requestFocus());
        campoNombre.addActionListener(e -> campoTelefono.requestFocus());
        campoTelefono.addActionListener(e -> campoEmail.requestFocus());
        campoEmail.addActionListener(e -> campoPassword.requestFocus());
        campoPassword.addActionListener(e -> campoConfirmarPassword.requestFocus());
        campoConfirmarPassword.addActionListener(e -> realizarRegistro());
    }
    
    /**
     * Realiza el proceso de registro.
     */
    private void realizarRegistro() {
        // Obtener datos de los campos
        String cedula = campoCedula.getText().trim();
        String nombre = campoNombre.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String email = campoEmail.getText().trim();
        String password = new String(campoPassword.getPassword());
        String confirmarPassword = new String(campoConfirmarPassword.getPassword());
        String tipoUsuario = (String) comboBoxTipoUsuario.getSelectedItem();
        
        // Validar campos vacíos
        if (cedula.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || 
            email.isEmpty() || password.isEmpty() || confirmarPassword.isEmpty()) {
            ventanaPrincipal.mostrarError("Por favor, complete todos los campos.", "Error de Validación");
            return;
        }
        
        // Validar contraseñas
        if (!password.equals(confirmarPassword)) {
            ventanaPrincipal.mostrarError("Las contraseñas no coinciden.", "Error de Validación");
            campoPassword.setText("");
            campoConfirmarPassword.setText("");
            campoPassword.requestFocus();
            return;
        }
        
        // Validar email
        if (!email.contains("@")) {
            ventanaPrincipal.mostrarError("Por favor, ingrese un email válido.", "Error de Validación");
            campoEmail.requestFocus();
            return;
        }
        
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        
        try {
            boolean exito = false;
            
            switch (tipoUsuario) {
                case "Usuario":
                    exito = controlador.registrarUsuario(cedula, nombre, telefono, password, email);
                    break;
                case "Administrador":
                    exito = controlador.registrarAdministrador(cedula, nombre, telefono, password, email);
                    break;
                case "Proveedor":
                    exito = controlador.registrarProveedor(cedula, nombre, telefono, password, email);
                    break;
            }
            
            if (exito) {
                ventanaPrincipal.mostrarMensaje("¡Registro exitoso! Ahora puede iniciar sesión.", "Registro Completado");
                ventanaPrincipal.mostrarPanelLogin();
                limpiarCampos();
            } else {
                ventanaPrincipal.mostrarError("Error al registrar. Verifique que la cédula no esté en uso.", "Error de Registro");
            }
        } catch (Exception ex) {
            ventanaPrincipal.mostrarError("Error durante el registro: " + ex.getMessage(), "Error del Sistema");
        }
    }
    
    /**
     * Limpia todos los campos de entrada.
     */
    private void limpiarCampos() {
        campoCedula.setText("");
        campoNombre.setText("");
        campoTelefono.setText("");
        campoEmail.setText("");
        campoPassword.setText("");
        campoConfirmarPassword.setText("");
        campoCedula.requestFocus();
    }
}
