package org.example.Logica;

import org.example.Interfaz.InterfazImpl;
import org.example.Modelo.Articulo;

public class ArticuloDAO extends InterfazImpl<Articulo,Integer> {
    public ArticuloDAO() {super(Articulo.class);}
}
