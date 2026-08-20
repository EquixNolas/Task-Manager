#  TaskManager CLI - Java

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

![TASKMANAGER](TASKMANAGER/docs/architecture/layered-diagram2.png)
