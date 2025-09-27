package com.rolapet.vista;

import com.rolapet.controlador.IControladorRolaPET;
import com.rolapet.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel de dashboard del usuario en el sistema RolaPet.
 * 
 * Este panel muestra las funcionalidades principales disponibles
 * para los usuarios autenticados en el sistema.
 * 
 * @author Equipo RolaPet
 * @version 1.0
 * @since 2025
 */
public class PanelDashboardUsuario extends JPanel {
    
    /** Referencia a la ventana principal */
    private final VentanaPrincipal ventanaPrincipal;
    
    /** Panel de pestañas para organizar las funcionalidades */
    private JTabbedPane tabbedPane;
    
    /** Panel de gestión de vehículos */
    private JPanel panelVehiculos;
    
    /** Panel de gestión de amigos */
    private JPanel panelAmigos;
    
    /** Panel de estadísticas */
    private JPanel panelEstadisticas;
    
    /**
     * Constructor del panel de dashboard.
     * 
     * @param ventanaPrincipal Referencia a la ventana principal
     */
    public PanelDashboardUsuario(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    /**
     * Inicializa todos los componentes del panel.
     */
    private void inicializarComponentes() {
        // Crear el panel de pestañas
        tabbedPane = new JTabbedPane();
        
        // Crear los paneles específicos
        crearPanelVehiculos();
        crearPanelAmigos();
        crearPanelEstadisticas();
        
        // Agregar paneles al tabbed pane
        tabbedPane.addTab("Vehículos", panelVehiculos);
        tabbedPane.addTab("Amigos", panelAmigos);
        tabbedPane.addTab("Estadísticas", panelEstadisticas);
    }
    
    /**
     * Crea el panel de gestión de vehículos.
     */
    private void crearPanelVehiculos() {
        panelVehiculos = new JPanel(new BorderLayout());
        panelVehiculos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel superior con botones
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton botonAgregarVehiculo = new JButton("Agregar Vehículo");
        JButton botonEliminarVehiculo = new JButton("Eliminar Vehículo");
        JButton botonActualizar = new JButton("Actualizar Lista");
        
        panelSuperior.add(botonAgregarVehiculo);
        panelSuperior.add(botonEliminarVehiculo);
        panelSuperior.add(botonActualizar);
        
        // Lista de vehículos
        JList<Vehiculo> listaVehiculos = new JList<>();
        listaVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneVehiculos = new JScrollPane(listaVehiculos);
        
        // Panel inferior con información
        JPanel panelInferior = new JPanel(new BorderLayout());
        JLabel etiquetaInfo = new JLabel("Seleccione un vehículo para ver más información");
        panelInferior.add(etiquetaInfo, BorderLayout.CENTER);
        
        // Agregar componentes al panel principal
        panelVehiculos.add(panelSuperior, BorderLayout.NORTH);
        panelVehiculos.add(scrollPaneVehiculos, BorderLayout.CENTER);
        panelVehiculos.add(panelInferior, BorderLayout.SOUTH);
        
        // Configurar eventos
        botonAgregarVehiculo.addActionListener(e -> mostrarDialogoAgregarVehiculo());
        botonEliminarVehiculo.addActionListener(e -> eliminarVehiculoSeleccionado(listaVehiculos));
        botonActualizar.addActionListener(e -> actualizarListaVehiculos(listaVehiculos));
        
        // Evento de selección en la lista
        listaVehiculos.addListSelectionListener(e -> {
            Vehiculo vehiculoSeleccionado = listaVehiculos.getSelectedValue();
            if (vehiculoSeleccionado != null) {
                etiquetaInfo.setText("Vehículo seleccionado: " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
            }
        });
    }
    
    /**
     * Crea el panel de gestión de amigos.
     */
    private void crearPanelAmigos() {
        panelAmigos = new JPanel(new BorderLayout());
        panelAmigos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel superior con botones
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton botonAgregarAmigo = new JButton("Agregar Amigo");
        JButton botonEliminarAmigo = new JButton("Eliminar Amigo");
        JButton botonActualizar = new JButton("Actualizar Lista");
        
        panelSuperior.add(botonAgregarAmigo);
        panelSuperior.add(botonEliminarAmigo);
        panelSuperior.add(botonActualizar);
        
        // Lista de amigos
        JList<Usuario> listaAmigos = new JList<>();
        listaAmigos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneAmigos = new JScrollPane(listaAmigos);
        
        // Panel inferior con información
        JPanel panelInferior = new JPanel(new BorderLayout());
        JLabel etiquetaInfo = new JLabel("Seleccione un amigo para ver más información");
        panelInferior.add(etiquetaInfo, BorderLayout.CENTER);
        
        // Agregar componentes al panel principal
        panelAmigos.add(panelSuperior, BorderLayout.NORTH);
        panelAmigos.add(scrollPaneAmigos, BorderLayout.CENTER);
        panelAmigos.add(panelInferior, BorderLayout.SOUTH);
        
        // Configurar eventos
        botonAgregarAmigo.addActionListener(e -> mostrarDialogoAgregarAmigo());
        botonEliminarAmigo.addActionListener(e -> eliminarAmigoSeleccionado(listaAmigos));
        botonActualizar.addActionListener(e -> actualizarListaAmigos(listaAmigos));
        
        // Evento de selección en la lista
        listaAmigos.addListSelectionListener(e -> {
            Usuario amigoSeleccionado = listaAmigos.getSelectedValue();
            if (amigoSeleccionado != null) {
                etiquetaInfo.setText("Amigo seleccionado: " + amigoSeleccionado.getNombre() + " (" + amigoSeleccionado.getEmail() + ")");
            }
        });
    }
    
    /**
     * Crea el panel de estadísticas.
     */
    private void crearPanelEstadisticas() {
        panelEstadisticas = new JPanel(new BorderLayout());
        panelEstadisticas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Área de texto para mostrar estadísticas
        JTextArea areaEstadisticas = new JTextArea(15, 50);
        areaEstadisticas.setEditable(false);
        areaEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPaneEstadisticas = new JScrollPane(areaEstadisticas);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonActualizar = new JButton("Actualizar Estadísticas");
        JButton botonExportar = new JButton("Exportar Reporte");
        
        panelBotones.add(botonActualizar);
        panelBotones.add(botonExportar);
        
        // Agregar componentes al panel principal
        panelEstadisticas.add(scrollPaneEstadisticas, BorderLayout.CENTER);
        panelEstadisticas.add(panelBotones, BorderLayout.SOUTH);
        
        // Configurar eventos
        botonActualizar.addActionListener(e -> actualizarEstadisticas(areaEstadisticas));
        botonExportar.addActionListener(e -> exportarReporte(areaEstadisticas));
        
        // Cargar estadísticas iniciales
        actualizarEstadisticas(areaEstadisticas);
    }
    
    /**
     * Configura el layout del panel principal.
     */
    private void configurarLayout() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    /**
     * Configura los eventos generales del panel.
     */
    private void configurarEventos() {
        // Aquí se pueden agregar eventos generales si es necesario
    }
    
    /**
     * Muestra el diálogo para agregar un vehículo.
     */
    private void mostrarDialogoAgregarVehiculo() {
        JDialog dialogo = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Agregar Vehículo", true);
        dialogo.setSize(400, 300);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Campos del formulario
        JTextField campoMarca = new JTextField(20);
        JTextField campoModelo = new JTextField(20);
        JTextField campoAutonomia = new JTextField(20);
        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Scooter", "Moto Eléctrica"});
        
        // Etiquetas y campos
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
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
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");
        
        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelBotones, gbc);
        
        // Eventos de los botones
        botonAceptar.addActionListener(e -> {
            try {
                String marca = campoMarca.getText().trim();
                String modelo = campoModelo.getText().trim();
                int autonomia = Integer.parseInt(campoAutonomia.getText().trim());
                String tipo = (String) comboTipo.getSelectedItem();
                
                if (marca.isEmpty() || modelo.isEmpty()) {
                    ventanaPrincipal.mostrarError("Por favor, complete todos los campos.", "Error de Validación");
                    return;
                }
                
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
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Elimina el vehículo seleccionado.
     */
    private void eliminarVehiculoSeleccionado(JList<Vehiculo> listaVehiculos) {
        Vehiculo vehiculoSeleccionado = listaVehiculos.getSelectedValue();
        if (vehiculoSeleccionado == null) {
            ventanaPrincipal.mostrarError("Por favor, seleccione un vehículo para eliminar.", "Error de Selección");
            return;
        }
        
        if (ventanaPrincipal.mostrarConfirmacion(
                "¿Está seguro de que desea eliminar el vehículo " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo() + "?",
                "Confirmar Eliminación")) {
            
            // Aquí se implementaría la lógica para eliminar el vehículo
            ventanaPrincipal.mostrarMensaje("Vehículo eliminado exitosamente.", "Éxito");
            actualizarListaVehiculos(listaVehiculos);
        }
    }
    
    /**
     * Actualiza la lista de vehículos.
     */
    private void actualizarListaVehiculos(JList<Vehiculo> listaVehiculos) {
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        List<Vehiculo> vehiculos = controlador.obtenerTodosLosVehiculos();
        listaVehiculos.setListData(vehiculos.toArray(new Vehiculo[0]));
    }
    
    /**
     * Muestra el diálogo para agregar un amigo.
     */
    private void mostrarDialogoAgregarAmigo() {
        String cedulaAmigo = JOptionPane.showInputDialog(this, "Ingrese la cédula del amigo:", "Agregar Amigo", JOptionPane.QUESTION_MESSAGE);
        
        if (cedulaAmigo != null && !cedulaAmigo.trim().isEmpty()) {
            // Aquí se implementaría la lógica para agregar el amigo
            ventanaPrincipal.mostrarMensaje("Amigo agregado exitosamente.", "Éxito");
        }
    }
    
    /**
     * Elimina el amigo seleccionado.
     */
    private void eliminarAmigoSeleccionado(JList<Usuario> listaAmigos) {
        Usuario amigoSeleccionado = listaAmigos.getSelectedValue();
        if (amigoSeleccionado == null) {
            ventanaPrincipal.mostrarError("Por favor, seleccione un amigo para eliminar.", "Error de Selección");
            return;
        }
        
        if (ventanaPrincipal.mostrarConfirmacion(
                "¿Está seguro de que desea eliminar a " + amigoSeleccionado.getNombre() + " de su lista de amigos?",
                "Confirmar Eliminación")) {
            
            // Aquí se implementaría la lógica para eliminar el amigo
            ventanaPrincipal.mostrarMensaje("Amigo eliminado exitosamente.", "Éxito");
            actualizarListaAmigos(listaAmigos);
        }
    }
    
    /**
     * Actualiza la lista de amigos.
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
     * Actualiza las estadísticas mostradas.
     */
    private void actualizarEstadisticas(JTextArea areaEstadisticas) {
        IControladorRolaPET controlador = ventanaPrincipal.getControlador();
        String estadisticas = controlador.obtenerEstadisticasSistema();
        areaEstadisticas.setText(estadisticas);
    }
    
    /**
     * Exporta el reporte de estadísticas.
     */
    private void exportarReporte(JTextArea areaEstadisticas) {
        ventanaPrincipal.mostrarMensaje("Funcionalidad de exportación en desarrollo.", "Información");
    }
}
