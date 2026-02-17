package org.example.ModeloDTO;

import org.example.Modelo.Diario;

public record DiarioDTO(
long idUsuario
){

    public DiarioDTO(Diario diario){
        this(
             diario.getIdUsuario()
        );
    }
}
