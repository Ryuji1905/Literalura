package com.aluracursos.literalura.service;
/**
 * Interfaz que define el contrato para la conversión
 * de datos en formato JSON a objetos Java.
 *
 * Permite desacoplar la lógica de conversión de datos
 * de su implementación concreta (por ejemplo, usando Jackson).
 *
 * Cualquier clase que implemente esta interfaz deberá
 * proporcionar la lógica para transformar un String JSON
 * en un objeto del tipo especificado.
 */
public interface IConvierteDatos {

    /**
     * Convierte un String en formato JSON a un objeto
     * del tipo indicado.
     *
     * El metodo es genérico (<T>) para permitir convertir
     * cualquier tipo de clase sin limitar la implementación
     * a un modelo específico.
     *
     * @param json  Cadena en formato JSON a convertir.
     * @param clase Clase destino del objeto.
     * @param <T>   Tipo genérico de retorno.
     * @return Objeto convertido del tipo especificado.
     */
    <T> T obtenerDatos(String json, Class<T> clase);
}