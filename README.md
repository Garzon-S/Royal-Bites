# Royal-Bites
<div align="center">

  <img src="https://github.com/user-attachments/assets/20c8e044-e222-48e5-8917-38de36410241" width="300" alt="RoyalBites" />

  <h1>🍔 Royal Bites 👑</h1>
  <h3><i>Sistema Web de Gestión Integrada para Restaurantes de Comidas Rápidas</i></h3>

  <p>
    <a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/Java-17+-orange.svg?style=for-the-badge&logo=java" alt="Java" /></a>
    <a href="https://spring.io/projects/spring-boot"><img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg?style=for-the-badge&logo=springboot" alt="Spring Boot" /></a>
    <a href="https://react.dev/"><img src="https://img.shields.io/badge/React-18.x-61DAFB.svg?style=for-the-badge&logo=react" alt="React" /></a>
    <a href="https://www.mysql.com/"><img src="https://img.shields.io/badge/MySQL-8.0-blue.svg?style=for-the-badge&logo=mysql" alt="MySQL" /></a>
  </p>

</div>

---

## 📌 Visión General del Proyecto

**Royal Bites** es una plataforma web Full Stack desarrollada para optimizar la administración operativa y el control de usuarios en un entorno de comidas rápidas. Permite gestionar de manera eficiente el acceso del personal y clientes mediante autenticación, administración por roles y control interactivo de estados.

---

## ✨ Características Principales

* 🔐 **Módulo de Autenticación:** Inicio de sesión seguro con gestión de datos persistentes.
* 👥 **Gestión Completa de Usuarios (CRUD):** 
  * Registro e integración de datos directamente con base de datos MySQL.
  * Edición dinámica de información personal y credenciales en pantalla modal.
  * Inactivación y reactivación rápida mediante toggles interactivos.
* 🛡️ **Seguridad por Roles:** Asignación de permisos según el perfil (`ADMIN`, `CAJERO`, `COCINERO`, `CLIENTE`).
* 🎨 **Interfaz Moderna & Responsive:** Dashboard intuitivo construido con React, diseñado con gradientes suaves, animaciones CSS y feedback visual instantáneo.

---

## 🛠️ Arquitectura y Tecnologías

### 🔵 Backend
* **Lenguaje:** Java 17+
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Persistencia:** Hibernate / JPA
* **Mapeo JSON:** Jackson Annotations (`@JsonProperty`)

### ⚛️ Frontend
* **Biblioteca:** React.js (Vite)
* **Enrutamiento:** React Router DOM
* **Estilos:** CSS3 personalizado con variables y diseño moderno tipo Dashboard

### 🗄️ Base de Datos
* **Motor:** MySQL WorkBench
* **Estructura:** Soporte para claves primarias compuestas (`@IdClass` con `PersonaId`)

---

## 📂 Estructura del Proyecto

```text
RoyalBites/
├── backend/
│   └── src/main/java/com/example/prueba1/
│       ├── controller/     # Endpoints REST (PersonaController, AuthController)
│       ├── entity/         # Entidades JPA y llaves compuestas (Persona, PersonaId)
│       └── repository/     # Repositorios JPA
└── frontend/
    └── src/
        ├── components/     # Componentes React (Login.jsx, Usuarios.jsx)
        ├── App.jsx         # Configuración de rutas
        └── index.css       # Estilos globales y diseño visual
