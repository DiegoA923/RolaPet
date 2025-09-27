package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.controlador.IControladorRolaPET;
import udistrital.avanzada.rolapet.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel de dashboard del usuario en el sistema RolaPet.
 * 
 * Este panel muestra las funcionalidades principales disponibles
 * para los usuarios autenticados en el sistema. Organiza las funciones
 * en pestañas para facilitar la navegación y el acceso a diferentes
 * características del sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class PanelDashboardUsuario extends JPanel {
    
    /** Referencia a la ventana principal para comunicación entre paneles */
    private final VentanaPrincipal ventanaPrincipal;
    
    /** Panel de pestañas para organizar las funcionalidades del dashboard */
    private JTabbedPane tabbedPane;
    
    /** Panel de gestión de vehículos del usuario */
    private JPanel panelVehiculos;
    
    /** Panel de gestión de amigos del usuario */
    private JPanel panelAmigos;
    
    /** Panel de estadísticas y reportes del sistema */
    private JPanel panelEstadisticas;
    
    /**
     * Constructor del panel de dashboard.
     * 
     * Este constructor inicializa el panel de dashboard con todos sus componentes,
     * crea las pestañas de funcionalidades y configura los eventos necesarios
     * para la gestión de vehículos, amigos y estadísticas.
     * 
     * @param ventanaPrincipal Referencia a la ventana principal para comunicación
     */
    public PanelDashboardUsuario(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    /**
     * Inicializa todos los componentes del panel.
     * 
     * Este método crea y configura todos los elementos del dashboard,
     * incluyendo el panel de pestañas y los paneles específicos para
     * cada funcionalidad del sistema.
     */
    private void inicializarComponentes() {
        // Crear el panel de pestañas principal
        tabbedPane = new JTabbedPane();
        
        // Crear los paneles específicos para cada funcionalidad
        crearPanelVehiculos();
        crearPanelAmigos();
        crearPanelEstadisticas();
        
        // Agregar todos los paneles al tabbed pane con títulos descriptivos
        tabbedPane.addTab("Vehículos", panelVehiculos);
        tabbedPane.addTab("Amigos", panelAmigos);
        tabbedPane.addTab("Estadísticas", panelEstadisticas);
    }
    
    /**
     * Crea el panel de gestión de vehículos.
     * 
     * Este método crea y configura el panel que permite a los usuarios
     * gestionar sus vehículos, incluyendo agregar, eliminar y consultar
     * vehículos asociados a su cuenta.
     */
    private void crearPanelVehiculos() {
        // Crear el panel principal con layout de borde
        panelVehiculos = new JPanel(new BorderLayout());
        panelVehiculos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crear el panel superior con botones de acción
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Crear los botones de gestión de vehículos
        JButton botonAgregarVehiculo = new JButton("Agregar Vehículo");
        JButton botonEliminarVehiculo = new JButton("Eliminar Vehículo");
        JButton botonActualizar = new JButton("Actualizar Lista");
        
        // Agregar los botones al panel superior
        panelSuperior.add(botonAgregarVehiculo);
        panelSuperior.add(botonEliminarVehiculo);
        panelSuperior.add(botonActualizar);
        
        // Crear la lista de vehículos con scroll
        JList<Vehiculo> listaVehiculos = new JList<>();
        listaVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneVehiculos = new JScrollPane(listaVehiculos);
        
        // Crear el panel inferior con información
        JPanel panelInferior = new JPanel(new BorderLayout());
        JLabel etiquetaInfo = new JLabel("Seleccione un vehículo para ver más información");
        panelInferior.add(etiquetaInfo, BorderLayout.CENTER);
        
        // Agregar todos los componentes al panel principal
        panelVehiculos.add(panelSuperior, BorderLayout.NORTH);
        panelVehiculos.add(scrollPaneVehiculos, BorderLayout.CENTER);
        panelVehiculos.add(panelInferior, BorderLayout.SOUTH);
        
        // Configurar los eventos de los botones
        botonAgregarVehiculo.addActionListener(e -> mostrarDialogoAgregarVehiculo());
        botonEliminarVehiculo.addActionListener(e -> eliminarVehiculoSeleccionado(listaVehiculos));
        botonActualizar.addActionListener(e -> actualizarListaVehiculos(listaVehiculos));
        
        // Configurar el evento de selección en la lista
        listaVehiculos.addListSelectionListener(e -> {
            Vehiculo vehiculoSeleccionado = listaVehiculos.getSelectedValue();
            if (vehiculoSeleccionado != null) {
                etiquetaInfo.setText("Vehículo seleccionado: " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
            }
        });
    }
    
    /**
     * Crea el panel de gestión de amigos.
     * 
     * Este método crea y configura el panel que permite a los usuarios
     * gestionar su lista de amigos, incluyendo agregar, eliminar y
     * consultar amigos en el sistema.
     */
    private void crearPanelAmigos() {
        // Crear el panel principal con layout de borde
        panelAmigos = new JPanel(new BorderLayout());
        panelAmigos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crear el panel superior con botones de acción
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Crear los botones de gestión de amigos
        JButton botonAgregarAmigo = new JButton("Agregar Amigo");
        JButton botonEliminarAmigo = new JButton("Eliminar Amigo");
        JButton botonActualizar = new JButton("Actualizar Lista");
        
        // Agregar los botones al panel superior
        panelSuperior.add(botonAgregarAmigo);
        panelSuperior.add(botonEliminarAmigo);
        panelSuperior.add(botonActualizar);
        
        // Crear la lista de amigos con scroll
        JList<Usuario> listaAmigos = new JList<>();
        listaAmigos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneAmigos = new JScrollPane(listaAmigos);
        
        // Crear el panel inferior con información
        JPanel panelInferior = new JPanel(new BorderLayout());
        JLabel etiquetaInfo = new JLabel("Seleccione un amigo para ver más información");
        panelInferior.add(etiquetaInfo, BorderLayout.CENTER);
        
        // Agregar todos los componentes al panel principal
        panelAmigos.add(panelSuperior, BorderLayout.NORTH);
        panelAmigos.add(scrollPaneAmigos, BorderLayout.CENTER);
        panelAmigos.add(panelInferior, BorderLayout.SOUTH);
        
        // Configurar los eventos de los botones
        botonAgregarAmigo.addActionListener(e -> mostrarDialogoAgregarAmigo());
        botonEliminarAmigo.addActionListener(e -> eliminarAmigoSeleccionado(listaAmigos));
        botonActualizar.addActionListener(e -> actualizarListaAmigos(listaAmigos));
        
        // Configurar el evento de selección en la lista
        listaAmigos.addListSelectionListener(e -> {
            Usuario amigoSeleccionado = listaAmigos.getSelectedValue();
            if (amigoSeleccionado != null) {
                etiquetaInfo.setText("Amigo seleccionado: " + amigoSeleccionado.getNombre() + " (" + amigoSeleccionado.getEmail() + ")");
            }
        });
    }
    
    /**
     * Crea el panel de estadísticas del sistema.
     * 
     * Este método crea y configura el panel que muestra estadísticas
     * generales del sistema y permite exportar reportes de información.
     */
    private void crearPanelEstadisticas() {
        // Crear el panel principal con layout de borde
        panelEstadisticas = new JPanel(new BorderLayout());
        panelEstadisticas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crear el área de texto para mostrar estadísticas
        JTextArea areaEstadisticas = new JTextArea(15, 50);
        areaEstadisticas.setEditable(false);
        areaEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPaneEstadisticas = new JScrollPane(areaEstadisticas);
        
        // Crear el panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonActualizar = new JButton("Actualizar Estadísticas");
        JButton botonExportar = new JButton("Exportar Reporte");
        
        // Agregar los botones al panel
        panelBotones.add(botonActualizar);
        panelBotones.add(botonExportar);
        
        // Agregar todos los componentes al panel principal
        panelEstadisticas.add(scrollPaneEstadisticas, BorderLayout.CENTER);
        panelEstadisticas.add(panelBotones, BorderLayout.SOUTH);
        
        // Configurar los eventos de los botones
        botonActualizar.addActionListener(e -> actualizarEstadisticas(areaEstadisticas));
        botonExportar.addActionListener(e -> exportarReporte(areaEstadisticas));
        
        // Cargar las estadísticas iniciales
        actualizarEstadisticas(areaEstadisticas);
    }
    
    /**
     * Configura el layout del panel principal.
     * 
     * Este método establece el layout principal del dashboard
     * y organiza los componentes de manera apropiada.
     */
    private void configurarLayout() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    /**
     * Configura los eventos generales del panel.
     * 
     * Este método establece los eventos generales que pueden
     * ser necesarios para el funcionamiento del dashboard.
     */
    private void configurarEventos() {
        // Aquí se pueden agregar eventos generales si es necesario
    }
    
    /**
     * Muestra el diálogo para agregar un vehículo.
     * 
     * Este método crea y muestra un diálogo modal que permite al usuario
     * ingresar los datos necesarios para crear un nuevo vehículo
     * en el sistema.
     */
    private void mostrarDialogoAgregarVehiculo() {
        // Crear el diálogo modal
        JDialog dialogo = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Agregar Vehículo", true);
        dialogo.setSize(400, 300);
        dialogo.setLocationRelativeTo(this);
        
        // Crear el panel del formulario
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Crear los campos del formulario
        JTextField campoMarca = new JTextField(20);
        JTextField campoModelo = new JTextField(20);
        JTextField campoAutonomia = new JTextField(20);
        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Scooter", "Moto Eléctrica"});
        
        // Configurar las etiquetas y campos
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Agregar los campos al formulario
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 1;
        panel.add(campoMarca, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1;
        panel.add(campoModelo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Autonomía (km):"), gbc);
        gbc.gridx = 1;
        panel.add(campoAutonomia, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        panel.add(comboTipo, gbc);
        
        // Crear los botones del diálogo
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");
        
        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelBotones, gbc);
        
        // Configurar los eventos de los botones
        botonAceptar.addActionListener(e -> {
            try {
                // Obtener los datos del formulario
                String marca = campoMarca.getText().trim();
                String modelo = campoModelo.getText().trim();
                int autonomia = Integer.parseInt(campoAutonomia.getText().trim());
                String tipo = (String) comboTipo.getSelectedItem();
                
                // Validar que los campos no estén vacíos
                if (marca.isEmpty() || modelo.isEmpty()) {
                    ventanaPrincipal.mostrarError("Por favor, complete todos los campos.", "Error de Validación");
                    return;
                }
                
                // Crear el vehículo usando el controlador
                IControladorRolaPET controlador = ventanaPrincipal.getControlador();
                Vehiculo vehiculo = controlador.crearVehiculo(marca, modelo, autonomia, tipo);
                
                if (vehiculo != null) {
                    ventanaPrincipal.mostrarMensaje("Vehículo creado exitosamente.", "Éxito");
                    dialogo.dispose();
                } else {
                    ventanaPrincipal.mostrarError("Error al crear el vehículo.", "Error");
                }
            } catch (NumberFormatException ex) {
                ventanaPrincipal.mostrarError("Por favor, ingrese un número válido para la autonomía.", "Error de Validación");
            }
        });
        
        botonCancelar.addActionListener(e -> dialogo.dispose());
        
        // Agregar el panel al diálogo y mostrarlo
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Elimina el vehículo seleccionado de la lista.
     * 
     * Este método obtiene el vehículo seleccionado en la lista,
     * solicita confirmación al usuario y procede con la eliminación
     * si es confirmada.
     * 
     * @param listaVehiculos Lista de vehículos de la cual eliminar
     */
    private void eliminarVehiculoSeleccionado(JList<Vehiculo> listaVehiculos) {
        // Obtener el vehículo seleccionado
        Vehiculo vehiculoSeleccionado = listaVehiculos.getSelectedValue();
        
        // Verificar que se haya seleccionado un vehículo
        if (vehiculoSeleccionado == null) {
            ventanaPrincipal.mostrarError("Por favor, seleccione un vehículo para eliminar.", "Error de Selección");
            return;
        }
        
        // Solicitar confirmación al usuario
        if (ventanaPrincipal.mostrarConfirmacion(
                "¿Está seguro de que desea eliminar el vehículo " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo() + "?",
                "Confirmar Eliminación")) {
            
            // Aquí se implementaría la lógica para eliminar el vehículo
            ventanaPrincipal.mostrarMensaje("Vehículo eliminado exitosamente.", "Éxito");
            actualizarListaVehiculos(listaVehiculos);
        }
    }
    
    /**
     * Actualiza la lista de vehículos mostrada.
     * 
     * Este método obtiene todos los vehículos del sistema
     * y actualiza la lista mostrada en la interfaz.
     * 
     * @param listaVehiculos Lista de vehículos a actualizar
     */
    private void actualizarListaVehiculos(JList<Vehiculo> listaVehiculos) {
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        List<Vehiculo> vehiculos = controlador.obtenerTodosLosVehiculos();
        listaVehiculos.setListData(vehiculos.toArray(new Vehiculo[0]));
    }
    
    /**
     * Muestra el diálogo para agregar un amigo.
     * 
     * Este método crea y muestra un diálogo que permite al usuario
     * ingresar la cédula de otro usuario para agregarlo como amigo.
     */
    private void mostrarDialogoAgregarAmigo() {
        String cedulaAmigo = JOptionPane.showInputDialog(this, "Ingrese la cédula del amigo:", "Agregar Amigo", JOptionPane.QUESTION_MESSAGE);
        
        if (cedulaAmigo != null && !cedulaAmigo.trim().isEmpty()) {
            // Aquí se implementaría la lógica para agregar el amigo
            ventanaPrincipal.mostrarMensaje("Amigo agregado exitosamente.", "Éxito");
        }
    }
    
    /**
     * Elimina el amigo seleccionado de la lista.
     * 
     * Este método obtiene el amigo seleccionado en la lista,
     * solicita confirmación al usuario y procede con la eliminación
     * si es confirmada.
     * 
     * @param listaAmigos Lista de amigos de la cual eliminar
     */
    private void eliminarAmigoSeleccionado(JList<Usuario> listaAmigos) {
        // Obtener el amigo seleccionado
        Usuario amigoSeleccionado = listaAmigos.getSelectedValue();
        
        // Verificar que se haya seleccionado un amigo
        if (amigoSeleccionado == null) {
            ventanaPrincipal.mostrarError("Por favor, seleccione un amigo para eliminar.", "Error de Selección");
            return;
        }
        
        // Solicitar confirmación al usuario
        if (ventanaPrincipal.mostrarConfirmacion(
                "¿Está seguro de que desea eliminar a " + amigoSeleccionado.getNombre() + " de su lista de amigos?",
                "Confirmar Eliminación")) {
            
            // Aquí se implementaría la lógica para eliminar el amigo
            ventanaPrincipal.mostrarMensaje("Amigo eliminado exitosamente.", "Éxito");
            actualizarListaAmigos(listaAmigos);
        }
    }
    
    /**
     * Actualiza la lista de amigos mostrada.
     * 
     * Este método obtiene todos los usuarios del sistema
     * y actualiza la lista de amigos mostrada en la interfaz.
     * 
     * @param listaAmigos Lista de amigos a actualizar
     */
    private void actualizarListaAmigos(JList<Usuario> listaAmigos) {
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        List<Usuario> usuarios = controlador.obtenerTodasLasPersonas().stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p)
                .toList();
        listaAmigos.setListData(usuarios.toArray(new Usuario[0]));
    }
    
    /**
     * Actualiza las estadísticas mostradas en el área de texto.
     * 
     * Este método obtiene las estadísticas del sistema
     * y las muestra en el área de texto del panel de estadísticas.
     * 
     * @param areaEstadisticas Área de texto donde mostrar las estadísticas
     */
    private void actualizarEstadisticas(JTextArea areaEstadisticas) {
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        String estadisticas = controlador.obtenerEstadisticasSistema();
        areaEstadisticas.setText(estadisticas);
    }
    
    /**
     * Exporta el reporte de estadísticas.
     * 
     * Este método permite exportar las estadísticas actuales
     * a un archivo o realizar otras acciones de exportación.
     * 
     * @param areaEstadisticas Área de texto con las estadísticas a exportar
     */
    private void exportarReporte(JTextArea areaEstadisticas) {
        ventanaPrincipal.mostrarMensaje("Funcionalidad de exportación en desarrollo.", "Información");
    }
}
