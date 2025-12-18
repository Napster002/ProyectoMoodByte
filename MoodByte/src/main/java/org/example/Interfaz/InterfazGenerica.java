package org.example.Interfaz;

import java.util.List;

public interface InterfazGenerica <T,K>{
    void insertar(T t);
    void actualizar(T t);
    T buscarPorId(K k);
    void borrarPorId(K k);
    List<T> listar();
}
