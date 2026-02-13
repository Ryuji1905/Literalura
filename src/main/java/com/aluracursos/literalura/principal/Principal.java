package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {

    private final Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";

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
                case 2 -> mostrarLibrosGuardados();
                case 3 -> mostrarAutoresGurdados();
                case 4 -> buscarAutoresVivosEnUnFecha();
                case 5 -> mostrarLibrosPorIdioma();
                case 0 -> System.out.println("Cerrando la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        }

        public
    }
}
