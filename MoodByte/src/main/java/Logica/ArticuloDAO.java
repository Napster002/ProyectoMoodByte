package Logica;

import Interfaz.InterfazImpl;
import Modelo.Articulo;
import Modelo.Registro;

public class ArticuloDAO extends InterfazImpl<Articulo,Integer> {
    public ArticuloDAO() {super(Articulo.class);}
}
