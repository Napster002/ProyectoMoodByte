package org.example.servicio;

import org.example.Logica.UsuarioRepository;
import org.example.Modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService<Usuario,Long> {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario modificar(Usuario usuario, Long id) {
       Usuario usu=repository.findById(id).orElse(null);
       if(usu!=null){
           usu.setNombreCompleto(usuario.getNombreCompleto());
           usu.setNombreUsuario(usuario.getNombreUsuario());
           usu.setPassword(usuario.getPassword());
           usu.setEdad(usuario.getEdad());
           usu.setGenero(usuario.getGenero());
           usu.setTipoUsuario(usuario.getTipoUsuario());
           usu.setFechaNacimiento(usuario.getFechaNacimiento());
       }
       return repository.save(usu);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
       repository.deleteById(id);
    }

    @Override
    public Usuario buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
