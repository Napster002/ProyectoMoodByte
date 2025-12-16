package Logica;

import Interfaz.InterfazImpl;
import Modelo.Estado;

public class EstadoDAO extends InterfazImpl<Estado,Integer> {

    public EstadoDAO() {
        super(Estado.class);
    }
}
