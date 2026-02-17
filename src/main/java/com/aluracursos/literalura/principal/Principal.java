package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.DatosBusqueda;
import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Principal {

    private final Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;



    public void muestraElMenu() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    1 - Buscar libros por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> buscarLibros();
//                case 2 -> mostrarLibrosGuardados();
//                case 3 -> mostrarAutoresGurdados();
//                case 4 -> buscarAutoresVivosEnUnFecha();
//                case 5 -> mostrarLibrosPorIdioma();
                case 0 -> System.out.println("Cerrando la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        }

    }

    private DatosLibro getDatosLibro() {
        System.out.println("Escriba el nombre del libro que deseas buscar (en ingles): ");
        var nombreLibro = teclado.nextLine();

        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));

        // Ahora mapeamos la respuesta completa
        DatosBusqueda datosBusqueda = conversor.obtenerDatos(json, DatosBusqueda.class);

        if (datosBusqueda.results() != null && !datosBusqueda.results().isEmpty()) {
            return datosBusqueda.results().get(0); // Tomamos el primer libro encontrado
        }

        return null;
    }


    private void buscarLibros(){
        DatosLibro datos = getDatosLibro();

        if (datos != null) {
            Libro libro = new Libro(datos);
            System.out.println(libro);
        } else {
            System.out.println("No se encontró ningún libro.");
        }
    }

}
