package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private final Scanner teclado = new Scanner(System.in);
    private final LibroService libroService;

    public Principal(LibroService libroService) {
        this.libroService = libroService;
    }

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
                case 1 -> {
                    System.out.println("Escriba el nombre del libro (en ingles): ");
                    String nombreLibro = teclado.nextLine();
                    libroService.buscarYGuardarLibro(nombreLibro);
                }
                case 2 -> libroService.listarLibros();
                case 3 -> libroService.listarAutores();
                case 4 -> {
                    System.out.println("Ingrese el año:");
                    var anio = teclado.nextInt();
                    teclado.nextLine();
                    libroService.listarAutoresVivosEn(anio);
                }
                case 5 -> {
                    System.out.println("Ingrese el idioma (ej: en, es, fr):");
                    var idioma = teclado.nextLine();
                    libroService.listarLibrosPorIdioma(idioma);
                }
                case 0 -> System.out.println("Cerrando la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
