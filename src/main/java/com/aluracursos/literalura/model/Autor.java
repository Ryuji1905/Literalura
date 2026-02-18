package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;
    private Integer nacimiento;
    private Integer fallece;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    public Autor(){}

    public Autor (DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.nacimiento = datosAutor.nacimiento();
        this.fallece = datosAutor.fallece();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallece() {
        return fallece;
    }

    public void setFallece(Integer fallece) {
        this.fallece = fallece;
    }

    @Override
    public String toString() {
        String salto = System.lineSeparator();

        return "********* AUTOR *********" + salto +
                "Nombre: " + nombre + salto +
                "Nacimiento: " + nacimiento + salto +
                "Fallecimiento: " + (fallece != null ? fallece : "Aún vivo") + salto +
                "Libros: " + listarTitulos() + salto +
                "*************************";
    }

    private String listarTitulos() {
        if (libros == null || libros.isEmpty()) {
            return "No tiene libros registrados.";
        }

        return libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
    }

}
