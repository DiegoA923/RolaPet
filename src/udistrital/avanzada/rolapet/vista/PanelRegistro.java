package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.controlador.IControladorRolaPET;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel de registro del sistema RolaPet.
 * 
 * Este panel permite a los usuarios registrarse en el sistema
 * proporcionando sus datos personales y credenciales. Incluye
 * validación de datos y verificación de duplicados para asegurar
 * la integridad de la información del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class PanelRegistro extends JPanel {
    
    /** Referencia a la ventana principal para comunicación entre paneles */
    private final VentanaPrincipal ventanaPrincipal;
    
    /** Campo de texto para ingresar la cédula de identificación */
    private JTextField campoCedula;
    
    /** Campo de texto para ingresar el nombre completo */
    private JTextField campoNombre;
    
    /** Campo de texto para ingresar el número de teléfono */
    private JTextField campoTelefono;
    
    /** Campo de texto para ingresar la dirección de email */
    private JTextField campoEmail;
    
    /** Campo de texto para ingresar la contraseña de acceso */
    private JPasswordField campoPassword;
    
    /** Campo de texto para confirmar la contraseña de acceso */
    private JPasswordField campoConfirmarPassword;
    
    /** Combo box para seleccionar el tipo de usuario a registrar */
    private JComboBox<String> comboBoxTipoUsuario;
    
    /** Botón para procesar el registro del nuevo usuario */
    private JButton botonRegistrar;
    
    /** Botón para cancelar el registro y volver al login */
    private JButton botonCancelar;
    
    /**
     * Constructor del panel de registro.
     * 
     * Este constructor inicializa el panel de registro con todos sus componentes,
     * configura el layout y establece los eventos necesarios para la funcionalidad
     * de registro y navegación.
     * 
     * @param ventanaPrincipal Referencia a la ventana principal para comunicación
     */
    public PanelRegistro(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    /**
     * Inicializa todos los componentes del panel.
     * 
     * Este método crea y configura todos los elementos de la interfaz
     * del panel de registro, incluyendo campos de texto, botones y
     * estableciendo sus propiedades básicas y tooltips informativos.
     */
    private void inicializarComponentes() {
        // Crear los campos de entrada para los datos del usuario
        campoCedula = new JTextField(20);
        campoNombre = new JTextField(20);
        campoTelefono = new JTextField(20);
        campoEmail = new JTextField(20);
        campoPassword = new JPasswordField(20);
        campoConfirmarPassword = new JPasswordField(20);
        
        // Crear el combo box para seleccionar tipo de usuario
        comboBoxTipoUsuario = new JComboBox<>(new String[]{"Usuario", "Administrador", "Proveedor"});
        
        // Crear los botones de acción
        botonRegistrar = new JButton("Registrar");
        botonCancelar = new JButton("Cancelar");
        
        // Establecer tamaños preferidos para los botones
        botonRegistrar.setPreferredSize(new Dimension(120, 30));
        botonCancelar.setPreferredSize(new Dimension(120, 30));
        
        // Configurar tooltips para ayudar al usuario
        campoCedula.setToolTipText("Ingrese su número de cédula");
        campoNombre.setToolTipText("Ingrese su nombre completo");
        campoTelefono.setToolTipText("Ingrese su número de teléfono");
        campoEmail.setToolTipText("Ingrese su dirección de email");
        campoPassword.setToolTipText("Ingrese una contraseña segura");
        campoConfirmarPassword.setToolTipText("Confirme su contraseña");
    }
    
    /**
     * Configura el layout del panel.
     * 
     * Este método organiza todos los componentes del panel utilizando
     * GridBagLayout para crear una disposición ordenada y centrada
     * de los elementos de la interfaz de registro.
     */
    private void configurarLayout() {
        // Establecer el layout principal del panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Crear el panel principal con GridBagLayout
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Configurar el título del panel
        JLabel etiquetaTitulo = new JLabel("Registro de Usuario - RolaPet");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Agregar el título al panel
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        panelPrincipal.add(etiquetaTitulo, gbc);
        
        // Configurar el campo de tipo de usuario
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 5, 10);
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Tipo de Usuario:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(comboBoxTipoUsuario, gbc);
        
        // Configurar el campo de cédula
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Cédula:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoCedula, gbc);
        
        // Configurar el campo de nombre
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoNombre, gbc);
        
        // Configurar el campo de teléfono
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Teléfono:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoTelefono, gbc);
        
        // Configurar el campo de email
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoEmail, gbc);
        
        // Configurar el campo de contraseña
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoPassword, gbc);
        
        // Configurar el campo de confirmar contraseña
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Confirmar Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoConfirmarPassword, gbc);
        
        // Configurar los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonCancelar);
        
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);
        
        // Agregar el panel principal al panel de contenido
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    /**
     * Configura los eventos de los componentes.
     * 
     * Este método establece todos los listeners necesarios para
     * manejar las interacciones del usuario con los componentes
     * del panel, incluyendo clics de botones y navegación entre campos.
     */
    private void configurarEventos() {
        // Configurar el evento del botón registrar
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarRegistro();
            }
        });
        
        // Configurar el evento del botón cancelar
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanelLogin();
            }
        });
        
        // Configurar eventos de Enter en los campos de texto para navegación
        campoCedula.addActionListener(e -> campoNombre.requestFocus());
        campoNombre.addActionListener(e -> campoTelefono.requestFocus());
        campoTelefono.addActionListener(e -> campoEmail.requestFocus());
        campoEmail.addActionListener(e -> campoPassword.requestFocus());
        campoPassword.addActionListener(e -> campoConfirmarPassword.requestFocus());
        campoConfirmarPassword.addActionListener(e -> realizarRegistro());
    }
    
    /**
     * Realiza el proceso de registro del nuevo usuario.
     * 
     * Este método obtiene todos los datos ingresados por el usuario,
     * valida que estén completos y sean correctos, verifica que no
     * existan duplicados, y procede con el registro utilizando
     * el controlador del sistema.
     */
    private void realizarRegistro() {
        // Obtener todos los datos ingresados por el usuario
        String cedula = campoCedula.getText().trim();
        String nombre = campoNombre.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String email = campoEmail.getText().trim();
        String password = new String(campoPassword.getPassword());
        String confirmarPassword = new String(campoConfirmarPassword.getPassword());
        String tipoUsuario = (String) comboBoxTipoUsuario.getSelectedItem();
        
        // Validar que todos los campos estén completos
        if (cedula.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || 
            email.isEmpty() || password.isEmpty() || confirmarPassword.isEmpty()) {
            ventanaPrincipal.mostrarError("Por favor, complete todos los campos.", "Error de Validación");
            return;
        }
        
        // Validar que las contraseñas coincidan
        if (!password.equals(confirmarPassword)) {
            ventanaPrincipal.mostrarError("Las contraseñas no coinciden.", "Error de Validación");
            campoPassword.setText("");
            campoConfirmarPassword.setText("");
            campoPassword.requestFocus();
            return;
        }
        
        // Validar que el email tenga formato válido
        if (!email.contains("@")) {
            ventanaPrincipal.mostrarError("Por favor, ingrese un email válido.", "Error de Validación");
            campoEmail.requestFocus();
            return;
        }
        
        // Obtener el controlador del sistema
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        
        try {
            // Realizar el registro según el tipo de usuario
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
            
            // Mostrar resultado del registro
            if (exito) {
                ventanaPrincipal.mostrarMensaje("¡Registro exitoso! Ahora puede iniciar sesión.", "Registro Completado");
                ventanaPrincipal.mostrarPanelLogin();
                limpiarCampos();
            } else {
                ventanaPrincipal.mostrarError("Error al registrar. Verifique que la cédula no esté en uso.", "Error de Registro");
            }
        } catch (Exception ex) {
            // Manejar cualquier error durante el proceso de registro
            ventanaPrincipal.mostrarError("Error durante el registro: " + ex.getMessage(), "Error del Sistema");
        }
    }
    
    /**
     * Limpia todos los campos de entrada del panel.
     * 
     * Este método borra el contenido de todos los campos de texto
     * del panel y establece el foco en el primer campo, preparando
     * el panel para una nueva entrada de datos.
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
