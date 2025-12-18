package org.example.Conexion;

import org.example.Modelo.Usuario;
import org.example.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuario")
class UsuarioController {
  private UsuarioService usuarioService;
  @Autowired
  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }
  @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
      return usuarioService.crear(usuario);
  }
  @GetMapping
    public List<Usuario> findAll() {
      return usuarioService.listar();
  }
  @DeleteMapping("/{id}")
      public void delete(@PathVariable Long id) {
       usuarioService.eliminar(id);
  }
  @PutMapping("/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
      return usuarioService.modificar(usuario, id);
  }
  @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
      return usuarioService.buscar(id);
  }
}
