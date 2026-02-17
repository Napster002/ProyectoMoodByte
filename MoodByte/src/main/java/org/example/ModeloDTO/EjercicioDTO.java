package org.example.ModeloDTO;

import org.example.Modelo.Ejercicio;

import java.sql.Time;

public record EjercicioDTO (
        long id,
        String titulo,
        String descripcion,
        String recursoUrl,
        Time duracion,
        long idEstado
){
    public EjercicioDTO(Ejercicio ejercicio){
        this(
          ejercicio.getId(),
          ejercicio.getTitulo(),
          ejercicio.getDescripcion(),
          ejercicio.getRecursoUrl(),
          ejercicio.getDuracion(),
          ejercicio.getEstado().getId()
        );
    }
}
