# 📚 Documentación — TaskManager
Sección de documentación técnica y funcional del proyecto TaskManager.

#  Índice
1. [Requisitos](#Requisitos)
2. Análisis.
3. Diseño.
4. Base de Datos.
5. Instalación.
6. Manual de usuario.

## Requisitos
  ### 01.- Requisitos Funcionales:
  
  * #### RF-01  Gestión de usuarios:   
  >El sistema debe permitir registrar, modificar y eliminar usuarios nuevos.
  * #### RF-02 - Gestión de Proyectos: 
  >El sistema debe detectar los proyectos del usuario y Permitirle crear nuevos proyectos, modificar los existentes o eliminarlos. El owner añade usuarios a su proyecto.
  * #### RF-03 - Gestión de Tareas:
  >Dentro de cada proyecto, el sistema debe permitir crear, modificar y eliminar las tareas propias si es usuarios y globales si es owner de proyecto.
  * #### RF-04 - Gestión de Etiquetas:
  >Permite crear etiquetas para asignarlas a las diferentes tareas.
  * #### RF-05 - Busqueda de Tareas: 
  >Permite filtrar las tareas por ID, TITTLE o ETIQUETA.
  * #### RF-06 - Comprobar Eliminación: 
  >Cuando un usuario es eliminado todos sus proyectos, tareas, etiquetas, etc. Se eliminan con el.
  * #### RF-07 - Listar Usuarios:
  >El sistema debe permitir listar todos los usuarios de un proyecto y solo del proyecto.
  * #### RF-08 - Listar Proyectos:
  >Listará los proyectos a los que esté asociado un usuario para elegir en cual trabaja.
  * #### RF-09 - Listar Tareas:
  >Lista todas las tareas a la que está asociado el usuario en el proyecto actual.
  * #### RF-10 - Listar por etiqueta: 
  >Permite listar tareas con una etiqueta determinada en el proyecto actual.

### 02.- Requisitos No Funcionales:

  * #### RNF-01  Persistencia:   
  >La información debe almacenarse de forma persistente en una base de datos de MySQL.
  * #### RNF-02  Arquitectura: 
  >La app debe usar arquitectura por capas.
  * #### RNF-03  Integridad: 
  >El sistema debe evitar crear tareas con fechas no válidas. También debe mantener la integridad de las contraseñas de los usuarios y sus datos anónimos.
  * #### RNF-04  Mantenibilidad:
  >El código debe estar organizado separando responsabilidades entre capas.

## Análisis
  
  ### Administrador del proyecto
  Es el encargado de administrar el proyecto, titulo, tareas, fechas de entrega y sobre todo usuarios.
  Puede:
  * Gestionar Usuarios.
  * Gestionar Proyectos.
  * Gestionar Tareas.
  * Cancelar / Eliminar el proyecto.
  * Consultar estado de progreso del proyecto.
  * Eliminar Usuarios.
![Casos-de-uso](TASKMANAGER/docs/uml/Use-Cases.png)
## Diseño
## Base de Datos
## Instalación
## Manual de usuario.
