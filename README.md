# 📝 Task Manager CLI - Java

Aplicación de gestión de tareas en consola desarrollada en Java para practicar Programación Orientada a Objetos (OOP), estructuras de datos y separación de responsabilidades.

---

## 🚀 Objetivo del proyecto

Este proyecto fue desarrollado para:

* Comprender los fundamentos de Java
* Aplicar principios básicos de OOP
* Practicar estructuras de control y colecciones
* Diseñar una arquitectura simple por capas
* Simular un pequeño sistema CRUD en entorno CLI

---

## 🧠 Arquitectura

El proyecto está dividido en tres capas principales:

* **Model** → Representa la entidad `Task`
* **Service** → Contiene la lógica de negocio y gestión de tareas
* **Main** → Gestiona la interacción con el usuario (interfaz de consola)

Esta separación permite mantener responsabilidades claras y facilita futuras mejoras como persistencia o migración a API REST.

---

## 📂 Estructura del proyecto

```
task-manager/
│
├── Main.java
├── model/
│   └── Task.java
├── service/
│   └── TaskService.java
```

---

## ⚙️ Funcionalidades

* Crear nueva tarea
* Listar todas las tareas
* Marcar tarea como completada
* Eliminar tarea
* Menú interactivo en consola

---

## 🛠 Tecnologías utilizadas

* Java
* Programación Orientada a Objetos
* Colecciones (List / ArrayList)
* Control de flujo (loops, condicionales)
* Manejo básico de entrada por consola

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

```
git clone https://github.com/tuusuario/task-manager.git
```

2. Compilar:

```
javac Main.java
```

3. Ejecutar:

```
java Main
```

---

## 📈 Posibles mejoras futuras

* Persistencia en archivo (TXT o JSON)
* Manejo avanzado de excepciones
* Tests unitarios
* Refactorización hacia arquitectura más desacoplada
* Migración a API REST con Spring Boot

---

## 🎯 Aprendizajes clave

Este proyecto permitió reforzar:

* Encapsulación
* Separación de responsabilidades
* Manipulación de colecciones
* Diseño básico de aplicaciones backend

---

## 👨‍💻 Autor

Desarrollado como parte del proceso de formación en backend y arquitectura de software.
