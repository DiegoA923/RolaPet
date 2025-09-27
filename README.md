# RolaPet - Sistema de Gestión de Vehículos Eléctricos

## Descripción del Proyecto

RolaPet es un sistema de escritorio desarrollado en Java que permite la gestión de vehículos eléctricos, usuarios, proveedores y administradores. El sistema está diseñado siguiendo los principios SOLID y la arquitectura Modelo-Vista-Controlador (MVC).

## Características Principales

- **Gestión de Usuarios**: Registro, autenticación y gestión de perfiles de usuario
- **Gestión de Vehículos**: Administración de scooters, motos eléctricas y otros vehículos
- **Sistema de Amigos**: Los usuarios pueden agregar y gestionar una lista de amigos
- **Gestión de Proveedores**: Administración de proveedores de servicios e insumos
- **Panel Administrativo**: Herramientas para administradores del sistema
- **Interfaz Gráfica**: Interfaz de usuario desarrollada con Java Swing

## Arquitectura del Sistema

### Patrón MVC (Modelo-Vista-Controlador)

El proyecto está estructurado siguiendo el patrón MVC:

- **Modelo** (`com.rolapet.modelo`): Contiene la lógica de negocio y las entidades del sistema
- **Vista** (`com.rolapet.vista`): Interfaz gráfica de usuario desarrollada con Swing
- **Controlador** (`com.rolapet.controlador`): Intermediario entre la vista y el modelo

### Principios SOLID

El diseño del sistema cumple con los 5 principios SOLID:

1. **S** - Principio de Responsabilidad Única (SRP)
2. **O** - Principio de Abierto/Cerrado (OCP)
3. **L** - Principio de Sustitución de Liskov (LSP)
4. **I** - Principio de Segregación de Interfaces (ISP)
5. **D** - Principio de Inversión de Dependencias (DIP)

## Estructura del Proyecto

```
RolaPet/
├── src/
│   └── com/
│       └── rolapet/
│           ├── modelo/          # Capa del Modelo
│           ├── vista/           # Capa de la Vista
│           └── controlador/     # Capa del Controlador
├── docs/                        # Documentación del proyecto
│   ├── integrantes.txt
│   └── repositorio_url.txt
├── specs/                       # Especificaciones y diagramas
└── README.md
```

## Entidades del Sistema

### Jerarquía de Personas
- **Persona** (Clase Abstracta): Base para todos los tipos de personas
- **Usuario**: Usuarios del sistema con gestión de vehículos y amigos
- **Administrador**: Administradores con privilegios especiales
- **Proveedor**: Proveedores de servicios e insumos

### Jerarquía de Vehículos
- **Vehiculo** (Clase Abstracta): Base para todos los vehículos
- **Scooter**: Scooters eléctricos
- **MotoElectrica**: Motos eléctricas

### Otras Entidades
- **Item**: Items que pueden ofrecer los proveedores (Servicio, Producto)
- **Publicacion**: Publicaciones de proveedores (Evento, Promoción)

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **Java Swing**: Framework para la interfaz gráfica
- **Patrón Singleton**: Para el repositorio de datos
- **Patrón MVC**: Arquitectura del sistema

## Requisitos del Sistema

- Java 8 o superior
- Sistema operativo compatible con Java (Windows, Linux, macOS)

## Instalación y Ejecución

1. Clonar o descargar el proyecto
2. Asegurarse de tener Java instalado
3. Compilar el proyecto:
   ```bash
   javac -cp . com/rolapet/modelo/*.java com/rolapet/controlador/*.java com/rolapet/vista/*.java
   ```
4. Ejecutar la aplicación:
   ```bash
   java com.rolapet.vista.VentanaPrincipal
   ```

## Funcionalidades del Sistema

### Para Usuarios
- Registro e inicio de sesión
- Gestión de vehículos personales
- Gestión de lista de amigos
- Visualización de estadísticas

### Para Administradores
- Gestión completa de usuarios
- Gestión de vehículos del sistema
- Gestión de proveedores
- Reportes y estadísticas del sistema

### Para Proveedores
- Gestión de items (servicios/productos)
- Creación de publicaciones
- Gestión de perfil

## Documentación

- Todas las clases están documentadas con JavaDoc
- El código sigue las convenciones estándar de Java
- Principios SOLID implementados en todo el diseño

## Contribución

Este es un proyecto universitario desarrollado por el Equipo RolaPet. Para contribuciones o sugerencias, contactar al equipo de desarrollo.

## Licencia

© 2025 Equipo RolaPet - Todos los derechos reservados

## Contacto

Para más información sobre el proyecto, contactar al equipo de desarrollo a través de los canales oficiales del proyecto.
