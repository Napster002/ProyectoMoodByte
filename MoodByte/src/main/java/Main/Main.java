package Main;

<<<<<<< Updated upstream
import Logica.RegistroDAO;
=======
import Conexion.ConexionMysqlEMF;
>>>>>>> Stashed changes
import Logica.UsuarioDAO;
import Modelo.Genero;
import Modelo.Registro;
import Modelo.TipoUsuario;
import Modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       ConexionMysqlEMF.getEmf();

       UsuarioDAO dao=new UsuarioDAO();
        Usuario usuario=new Usuario();
        usuario.setEdad(31);
        usuario.setGenero(Genero.Hombre);
        usuario.setNombreUsuario("Ruben.cobo");
        usuario.setNombreCompleto("Ruben Cobo Gonzalez");
        usuario.setPassword("Chimichangaaaaaas");
        usuario.setTipoUsuario(TipoUsuario.Administrador);
        dao.insertar(usuario);

        RegistroDAO reo=new RegistroDAO();
        Registro R1=new Registro();
        R1.setFechaRegistro(LocalDate.now());
        R1.setPuntuacion(5);
        R1.setUsuario(usuario);

        reo.insertar(R1);

        List<Registro> regis = new ArrayList<>();
        regis.add(R1);
        usuario.setRegistros(regis);
        dao.actualizar(usuario);

        List<Registro> lista=dao.mostrarRegistros(usuario);
        System.out.println("Lista registros del usuario 1:");
        lista.forEach(r-> System.out.println(r.toString()));
    }
}