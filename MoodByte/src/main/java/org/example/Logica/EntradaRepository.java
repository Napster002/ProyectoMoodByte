package org.example.Logica;

import org.example.Modelo.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    List<Entrada> findByDiarioIdUsuario(Long idUsuario);
}
