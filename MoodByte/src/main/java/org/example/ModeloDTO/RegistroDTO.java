package org.example.ModeloDTO;

import org.example.Modelo.Registro;

import java.time.LocalDate;

public record RegistroDTO(
        int puntuacion,
        LocalDate fechaRegistro,
        long idUsuario
        ) {
    public RegistroDTO(Registro registro){
        this(
          registro.getPuntuacion(),
          registro.getFechaRegistro(),
          registro.getUsuario().getId()
        );
    }
}
