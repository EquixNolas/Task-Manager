# 📇 Base de Datos
  ### Entidades Principales
  * #### Usuario
  > Representa a las personas que emplean la aplicacón.
  * #### Proyectos
  >Representa los proyectos existentes para cada usuario.
  * #### Tareas
  >Representa las tareas asignadas a un proyecto.
  * #### Etiquetas
  > Representa las etiquetas asignadas a diferentes tateas.
  * #### Tarea Etiqueta
  > Representa la relación entre una tarea y una etiqueta.

<p align="center">
  <img src="Entity-Relationship-Diagram.png" width="800" alt="arquitectura por capas.">
</p>

  ### Relaciones
  >1. Un Usuario puede tener varios proyectos.
  >2. Un proyecto puede tener varios usuarios.
  >3. Un Proyecto solo tiene un owner.
  >4. Una tarea puede tener muchos usuarios.
  >5. Una tarea solo pertenece a un proyecto.
  >6. Un proyecto puede tener múltiples tareas.
  >7. Una tarea puede tener varias etiquetas.
  >8. Una etiqueta puede tener muchas tareas.
  >9. Una tarea tiene un estado.
  >10. Un estado puede estar en muchas tareas.
  >11. Una tarea tiene una prioridad.
  >12. Una prioridad puede estar en muchas tareas.
