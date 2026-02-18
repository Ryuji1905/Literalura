 📚 Literalura

Aplicación de consola desarrollada con Java + Spring Boot que consume la API de Gutendex para buscar libros y almacenarlos en una base de datos PostgreSQL.

Permite consultar libros y autores registrados aplicando persistencia con JPA y relaciones entre entidades.

🚀 Funcionalidades

Buscar libro por título (API Gutendex)

Guardar libros en base de datos

Evitar duplicados por gutendexId

Listar libros registrados

Listar autores registrados

Buscar libros por idioma

Listar autores vivos en un año determinado

🛠️ Tecnologías

Java 17+

Spring Boot

Spring Data JPA

Hibernate

PostgreSQL

API Gutendex

🗄️ Base de Datos

Crear base de datos:

CREATE DATABASE literalura;


Configurar en application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update

🧠 Arquitectura

Principal → Menú e interacción con usuario

Service → Lógica de negocio

Repository → Acceso a datos

Model → Entidades (Libro ↔ Autor)

🎯 Objetivo

Proyecto práctico para reforzar:

Consumo de APIs REST

Persistencia con JPA

Relaciones entre entidades

Arquitectura en capas
