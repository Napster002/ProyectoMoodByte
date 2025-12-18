package org.example.servicio;

import java.util.List;

public interface ServicioGenerica<T,Long> {
    T crear(T t);
    T modificar(T t,Long id);
    List<T> listar();
    void eliminar(Long id);
    T buscar(Long id);
}
