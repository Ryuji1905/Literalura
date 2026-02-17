package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
    /**
     * Instancia de ObjectMapper utilizada para realizar
     * la conversión de JSON a objetos Java.
     */
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Convierte un String en formato JSON a un objeto
     * del tipo especificado.
     *
     * El metodo es genérico (<T>) para permitir reutilización
     * con diferentes clases (por ejemplo: DatosSerie,
     * DatosTemporadas, DatosEpisodio, etc.).
     *
     * @param json  Cadena en formato JSON que se desea convertir.
     * @param clase Clase destino a la que se mapearán los datos.
     * @param <T>   Tipo genérico del objeto de retorno.
     * @return Objeto del tipo especificado con los datos del JSON.
     * @throws RuntimeException si ocurre un error durante la conversión.
     */
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
