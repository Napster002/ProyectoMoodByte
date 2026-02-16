package org.example.ModeloDTO;

import org.example.Modelo.Estado;

public record EstadoDTO(
        long id,
        String nombre
) {
    public EstadoDTO(Estado estado){
        this(
                estado.getId(),
                estado.getNombre()
        );
    }
}
