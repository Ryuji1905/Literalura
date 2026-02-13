package com.aluracursos.literalura.service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    /**
     * Realiza una petición HTTP GET a la URL proporcionada
     * y devuelve el cuerpo de la respuesta como String.
     *
     * @param url Dirección completa de la API a consumir.
     * @return Respuesta en formato JSON como String.
     * @throws RuntimeException si ocurre un error de conexión
     *                          o la solicitud es interrumpida.
     */
    public String obtenerDatos(String url){

        // Cliente HTTP que envía la solicitud
        HttpClient client = HttpClient.newHttpClient();

        // Construcción de la solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;

        try {
            // Envío de la solicitud y recepción de la respuesta como String
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Error de entrada/salida (problemas de red, conexión, etc.)
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Si el hilo es interrumpido durante la petición
            throw new RuntimeException(e);
        }

        // Cuerpo de la respuesta (JSON)
        String json = response.body();

        return json;
    }
}
