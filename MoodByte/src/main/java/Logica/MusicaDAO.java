package Logica;

import Interfaz.InterfazImpl;
import Modelo.Musica;
import Modelo.Registro;

public class MusicaDAO extends InterfazImpl<Musica,Integer> {
    public MusicaDAO() {super(Musica.class);}
}
