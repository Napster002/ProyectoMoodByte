package Logica;

import Interfaz.InterfazImpl;
import Modelo.Ejercicio;

public class EjercicioDAO extends InterfazImpl<Ejercicio,Integer> {

    public EjercicioDAO() {
        super(Ejercicio.class);
    }
}
