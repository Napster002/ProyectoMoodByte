package org.example.ModeloDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.example.Modelo.Genero;
import org.example.Modelo.TipoUsuario;
import org.example.Modelo.Usuario;

import java.time.LocalDate;

public record UsuarioDTO(
        long id,
        String nombreCompleto,
        String nombreUsuario,
        String password,
        int edad,
        @Enumerated(EnumType.STRING)
        Genero genero,
        @Enumerated(EnumType.STRING)
        TipoUsuario tipoUsuario,
        LocalDate fechaRegistro,
        LocalDate fechaNacimiento,
        int nivel,

        double expAcumulada) {
    public UsuarioDTO(Usuario usuario){
        this(
          usuario.getId(),
          usuario.getNombreCompleto(),
          usuario.getNombreUsuario(),
                usuario.getPassword(),
                usuario.getEdad(),
                usuario.getGenero(),
                usuario.getTipoUsuario(),
                usuario.getFechaRegistro(),
                usuario.getFechaNacimiento(),
                usuario.getNivel(),
                usuario.getExpAcumulada()
        );
    }
}
