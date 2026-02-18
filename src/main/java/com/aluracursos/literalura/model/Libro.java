package com.aluracursos.literalura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "libros")


public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long gutendexId;  // ID que viene del API

    @Column(unique = true, length = 1000)
    private String titulo;

    @ManyToOne
    private Autor autor;

    @Column(columnDefinition = "TEXT")
    private String resumen;

    private String lenguajes;

    public Libro(DatosLibro datosLibro){
        this.gutendexId = datosLibro.id();
        this.titulo = datosLibro.titulo();

        if (!datosLibro.autores().isEmpty()) {
            this.autor = new Autor(datosLibro.autores().get(0));
        }

        if (!datosLibro.resumen().isEmpty()) {
            this.resumen = datosLibro.resumen().get(0);
        }

        this.lenguajes = String.join(",", datosLibro.lenguajes());
    }

    public Libro() {
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    @Override
    public String toString() {
        String salto = System.lineSeparator();

        return "********* LIBRO *********" + salto +
                "ID: " + id + salto +
                "Título: " + titulo + salto +
                "Autor: " + (autor != null ? autor.getNombre() : "Desconocido") + salto +
                "Resumen: " + resumen + salto +
                "Idioma: " + lenguajes + salto +
                "*************************";
    }

}
