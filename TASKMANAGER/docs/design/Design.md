# Diseño
  ### Diagrama de Clases
  >El siguiente diagrama representa las principales entidades del dominio y las relaciones existentes entre ellas.

<p align="center">
  <img src="design/UML-Diagram.png" width="600" alt="Diagrama de clases.">
</p>

  ### Diagrama de Secuencia: Crear Tarea
  1. El usuario Solicita crear una  tarea.
  2. El controller recibe la solicitud.
  3. El Service valida los datos.
  4. Se comprueba que la tarea no exista de antes.
  5. El Dao/Repository persiste la reserva.
  6. El sistema devuelve el resultado.
> ![secuencia](design/Secuence-diagram.png)

  ### Arquitectura por capas
  * #### Controller
  > Gestiona las solicitudes recibidas y delega las operaciones necesarias en la capa de servicios. También recibe el resultado final.
  * #### Service
  > Contiene la lógica de negocio y las validaciones del sistema.
  * #### DAO / Repository
  > Gestiona el acceso a los datos utilizando JPA.
  * #### Entity
  > Representa las entidades del dominio y su relación con la base de datos.

<p align="center">
  <img src="design/layered-diagram2.jpg" width="800" alt="arquitectura por capas.">
</p>
