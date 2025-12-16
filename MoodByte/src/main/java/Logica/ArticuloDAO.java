package Logica;

import Interfaz.InterfazImpl;
import Modelo.Articulo;

public class ArticuloDAO extends InterfazImpl<Articulo,Integer> {
    public ArticuloDAO() {
        super(Articulo.class);
    }
}
