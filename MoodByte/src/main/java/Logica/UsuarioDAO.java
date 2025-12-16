package Logica;

import Interfaz.InterfazImpl;
import Modelo.Usuario;

public class UsuarioDAO extends InterfazImpl<Usuario,Integer> {
    public UsuarioDAO() {
        super(Usuario.class);
    }
}
