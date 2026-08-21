# 📝 TaskManager CLI - Java

Es una aplicación desarrollada en Java para la gestión de tareas. 
Permite administrar usuarios, proyectos, tareas y etiquetas.
Así como comprobar las fechas de cada tarea y proyecto.

#  Características
* Gestión de proyectos.
* Gestión de Tareas.
* Gestión de usuarios.
* Eliminación de usuarios.
* Comprobación de usuarios.
* Validación de fechas.
* Búsqueda por etiquetas.

# Tecnologías
![Java](https://img.shields.io/badge/Java-21-grey?labelColor=red)
![MySQL](https://img.shields.io/badge/MySQL-8.0.03-grey?logo=mysql&logoColor=white&logoSize=auto&labelColor=4D9FEB)
![Hibernate](https://img.shields.io/badge/JPA/Hibernate-3.1-grey?logo=hibernate&labelColor=dbca8e)
![Eclipse](https://img.shields.io/badge/MySQL-8.0.03-grey?logo=eclipseide&labelColor=2B2152)
![VisualParadigm](https://img.shields.io/badge/VisualParadigm-Web-grey?logo=visualparadigm&labelColor=red)
![License](https://img.shields.io/badge/License-GPL--3.0-grey?labelColor=blue)
![Status](https://img.shields.io/badge/Status-In%20Progress-yellow)

#  Arquitectura
El proyecto utiliza una arquitectura por capas para separar las responsabilidades de la aplicación.
El controller Gestiona las acciones recibidas, el Service contiene la lógica de negocio 
y el DAO/Repository se encarga del acceso a los datos mediante JPA.

![layered-diagram](docs/diseno/layered-diagram2.jpg)

#  Modelo de datos
La base de datos está formada principalmente por las entidades Usuarios, Proyectos y Tareas.
Cada Usuario tiene un proyecto asignado y en estos proyectos se encuentran las tareas a realizar por dicho usuario con una fecha limite.

![ER-Diagram](docs/base-datos/Entity-Relationship-Diagram.png)

# Capturas de la CLI | In progress
* Auntetificación.
* Gestión de Usuario.
* Main Menu.
* Gestión de Proyectos.
* Gestión de Tareas.
* Gestión de Etiquetas.
* Crear Proyecto / Tarea / Etiqueta.

#  Documentación
📁 [Requisitos](docs/requisitos.md)
📁 [Diseño](docs/diseno/Design.md)
📁 [Base de datos](docs/base-datos/data-model.md)
📁 [Instalación](docs/Instalación.md)
📁 [Manual de usuario](docs/Manual-de-usuario.md)
