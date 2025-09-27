package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.controlador.IControladorRolaPET;
import udistrital.avanzada.rolapet.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel de login del sistema RolaPet.
 * 
 * Este panel permite a los usuarios autenticarse en el sistema
 * con sus credenciales (email/contraseña para usuarios, cédula/contraseña para otros).
 * Proporciona una interfaz intuitiva para el proceso de autenticación
 * y navegación hacia el registro de nuevos usuarios.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class PanelLogin extends JPanel {
    
    /** Referencia a la ventana principal para comunicación entre paneles */
    private final VentanaPrincipal ventanaPrincipal;
    
    /** Campo de texto para ingresar email o cédula según el tipo de usuario */
    private JTextField campoCredencial;
    
    /** Campo de texto para ingresar la contraseña de acceso */
    private JPasswordField campoPassword;
    
    /** Combo box para seleccionar el tipo de usuario (Usuario, Administrador, Proveedor) */
    private JComboBox<String> comboBoxTipoUsuario;
    
    /** Botón para iniciar sesión con las credenciales ingresadas */
    private JButton botonLogin;
    
    /** Botón para navegar al panel de registro de nuevos usuarios */
    private JButton botonRegistro;
    
    /**
     * Constructor del panel de login.
     * 
     * Este constructor inicializa el panel de login con todos sus componentes,
     * configura el layout y establece los eventos necesarios para la funcionalidad
     * de autenticación y navegación.
     * 
     * @param ventanaPrincipal Referencia a la ventana principal para comunicación
     */
    public PanelLogin(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    /**
     * Inicializa todos los componentes del panel.
     * 
     * Este método crea y configura todos los elementos de la interfaz
     * del panel de login, incluyendo etiquetas, campos de texto, botones
     * y estableciendo sus propiedades básicas.
     */
    private void inicializarComponentes() {
        // Crear etiquetas para los campos
        JLabel etiquetaTipoUsuario = new JLabel("Tipo de Usuario:");
        JLabel etiquetaCredencial = new JLabel("Email/Cédula:");
        JLabel etiquetaPassword = new JLabel("Contraseña:");
        
        // Crear el combo box para seleccionar tipo de usuario
        comboBoxTipoUsuario = new JComboBox<>(new String[]{"Usuario", "Administrador", "Proveedor"});
        
        // Crear los campos de entrada
        campoCredencial = new JTextField(20);
        campoPassword = new JPasswordField(20);
        
        // Crear los botones de acción
        botonLogin = new JButton("Iniciar Sesión");
        botonRegistro = new JButton("Registrarse");
        
        // Configurar tooltips para ayudar al usuario
        campoCredencial.setToolTipText("Ingrese su email (usuarios) o cédula (administradores/proveedores)");
        campoPassword.setToolTipText("Ingrese su contraseña de acceso");
        
        // Establecer tamaños preferidos para los botones
        botonLogin.setPreferredSize(new Dimension(120, 30));
        botonRegistro.setPreferredSize(new Dimension(120, 30));
    }
    
    /**
     * Configura el layout del panel.
     * 
     * Este método organiza todos los componentes del panel utilizando
     * GridBagLayout para crear una disposición ordenada y centrada
     * de los elementos de la interfaz.
     */
    private void configurarLayout() {
        // Establecer el layout principal del panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Crear el panel principal con GridBagLayout
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Configurar el título del panel
        JLabel etiquetaTitulo = new JLabel("Iniciar Sesión - RolaPet");
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
        
        // Configurar el campo de credencial
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Email/Cédula:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoCredencial, gbc);
        
        // Configurar el campo de contraseña
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoPassword, gbc);
        
        // Configurar los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonLogin);
        panelBotones.add(botonRegistro);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
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
     * del panel, incluyendo clics de botones y cambios en los campos.
     */
    private void configurarEventos() {
        // Configurar el evento del botón de login
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        
        // Configurar el evento del botón de registro
        botonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanelRegistro();
            }
        });
        
        // Configurar eventos de Enter en los campos de texto
        campoCredencial.addActionListener(e -> realizarLogin());
        campoPassword.addActionListener(e -> realizarLogin());
        
        // Configurar el evento de cambio en el combo box
        comboBoxTipoUsuario.addActionListener(e -> actualizarEtiquetaCredencial());
    }
    
    /**
     * Realiza el proceso de autenticación del usuario.
     * 
     * Este método obtiene las credenciales ingresadas por el usuario,
     * valida que no estén vacías, y según el tipo de usuario seleccionado,
     * intenta autenticarlo utilizando el controlador del sistema.
     * Muestra mensajes apropiados según el resultado de la autenticación.
     */
    private void realizarLogin() {
        // Obtener los datos ingresados por el usuario
        String credencial = campoCredencial.getText().trim();
        String password = new String(campoPassword.getPassword());
        String tipoUsuario = (String) comboBoxTipoUsuario.getSelectedItem();
        
        // Validar que los campos no estén vacíos
        if (credencial.isEmpty() || password.isEmpty()) {
            ventanaPrincipal.mostrarError("Por favor, complete todos los campos.", "Error de Validación");
            return;
        }
        
        // Obtener el controlador del sistema
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        
        try {
            // Realizar la autenticación según el tipo de usuario
            switch (tipoUsuario) {
                case "Usuario":
                    // Autenticar usuario con email y contraseña
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
                    // Autenticar administrador con cédula y contraseña
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
                    // Autenticar proveedor con cédula y contraseña
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
            // Manejar cualquier error durante el proceso de autenticación
            ventanaPrincipal.mostrarError("Error durante el proceso de autenticación: " + ex.getMessage(), "Error del Sistema");
        }
    }
    
    /**
     * Actualiza la etiqueta de credencial según el tipo de usuario seleccionado.
     * 
     * Este método cambia el tooltip del campo de credencial para indicar
     * al usuario qué tipo de información debe ingresar según el tipo
     * de usuario seleccionado (email para usuarios, cédula para otros).
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
     * Limpia todos los campos de entrada del panel.
     * 
     * Este método borra el contenido de todos los campos de texto
     * del panel y establece el foco en el primer campo, preparando
     * el panel para una nueva entrada de datos.
     */
    private void limpiarCampos() {
        campoCredencial.setText("");
        campoPassword.setText("");
        campoCredencial.requestFocus();
    }
}
