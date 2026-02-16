package org.example.ModeloDTO;

import org.example.Modelo.Frase;

public record FraseDTO(
        long id,
        String frase,
        int puntuacion
) {
    public FraseDTO(Frase frase){
     this(
       frase.getId(),
       frase.getFrase(),
       frase.getPuntuacion()
     );
    }
}
