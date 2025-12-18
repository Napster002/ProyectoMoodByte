package Logica;

import Interfaz.InterfazImpl;
import Modelo.Rutina;

public class RutinaDAO extends InterfazImpl<Rutina,Integer> {
    public RutinaDAO() {
        super(Rutina.class);
    }
}
