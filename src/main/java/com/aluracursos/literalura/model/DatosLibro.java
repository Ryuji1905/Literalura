package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id")Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors")String autores,
        @JsonAlias("summaries") String resumen,
        @JsonAlias("languages")String lenguajes                 ) {
}
