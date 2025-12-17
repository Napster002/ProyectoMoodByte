package Main;

import Logica.UsuarioDAO;
import Modelo.Genero;
import Modelo.TipoUsuario;
import Modelo.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao=new UsuarioDAO();
        Usuario usuario=new Usuario();
        usuario.setEdad(31);
        usuario.setGenero(Genero.Hombre);
        usuario.setNombreUsuario("Ruben.cobo");
        usuario.setNombreCompleto("Ruben Cobo Gonzalez");
        usuario.setPassword("Chimichangaaaaaas");
        usuario.setTipoUsuario(TipoUsuario.Administrador);
        dao.insertar(usuario);
    }
}