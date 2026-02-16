package org.example.ModeloDTO;

import org.example.Modelo.Entrada;

import java.time.LocalDate;

public record EntradaDTO(
        long id,
        String texto,
        LocalDate fechaEntrada,
        long idDiario
) {
    public EntradaDTO(Entrada entrada) {
        this(
                entrada.getId(),
                entrada.getTexto(),
                entrada.getFechaEntrada(),
                entrada.getDiario().getIdUsuario()
        );
    }

}
