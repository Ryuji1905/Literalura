package com.aluracursos.literalura.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")

public class Libro {
    @Id
    private Long id;

    @Column(unique = true)
    private String titulo;
    private String autores;
    private String resumen;
    private String lenguajes;
}
