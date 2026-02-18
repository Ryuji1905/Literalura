package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final ConsumoAPI consumoAPI;
    private final ConvierteDatos conversor;

    public LibroService(LibroRepository libroRepository,
                        AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.consumoAPI = new ConsumoAPI();
        this.conversor = new ConvierteDatos();
    }

    public void buscarYGuardarLibro(String nombreLibro) {

        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));
        DatosBusqueda datosBusqueda = conversor.obtenerDatos(json, DatosBusqueda.class);

        if (datosBusqueda.results() == null || datosBusqueda.results().isEmpty()) {
            System.out.println("No se encontró ningún libro.");
            return;
        }

        DatosLibro datos = datosBusqueda.results().get(0);

        //  AQUÍ VA LA VALIDACIÓN
        if (libroRepository.findByGutendexId(datos.id()).isPresent()) {
            System.out.println("El libro ya está registrado en la base de datos.");
            return;
        }

        Autor autor = new Autor(datos.autores().get(0));

        Optional<Autor> autorExistente =
                autorRepository.findByNombre(autor.getNombre());

        if (autorExistente.isPresent()) {
            autor = autorExistente.get();
        } else {
            autorRepository.save(autor);
        }

        Libro libro = new Libro(datos);
        libro.setAutor(autor);

        libroRepository.save(libro);

        System.out.println("Libro guardado correctamente:");
        System.out.println(libro);
    }

    public void listarLibros() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    public void listarAutoresVivosEn(int anio) {
        List<Autor> autores = autorRepository
                .findByNacimientoLessThanEqualAndFalleceGreaterThanEqual(anio, anio);

        autores.forEach(System.out::println);
    }

    public void listarLibrosPorIdioma(String idioma) {
        List<Libro> libros = libroRepository.findByLenguajesContainingIgnoreCase(idioma);
        libros.forEach(System.out::println);
    }
}
