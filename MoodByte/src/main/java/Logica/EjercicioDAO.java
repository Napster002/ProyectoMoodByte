package Logica;

import Interfaz.InterfazImpl;
import Modelo.Ejercicio;
import Modelo.Registro;

public class EjercicioDAO extends InterfazImpl<Ejercicio,Integer> {
    public EjercicioDAO() {super(Ejercicio.class);}
}
