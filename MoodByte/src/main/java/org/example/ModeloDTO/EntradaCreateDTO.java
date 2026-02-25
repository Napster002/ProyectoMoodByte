package org.example.ModeloDTO;

import java.time.LocalDate;

public record EntradaCreateDTO(
        long id,
        String texto,
        LocalDate fechaEntrada,
        long idDiario
) {}
