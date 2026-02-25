package org.example.Conexion;


import org.apache.catalina.connector.Response;
import org.example.Modelo.Usuario;
import org.example.ModeloDTO.UsuarioDTO;
import org.example.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {  // ⚡ Ahora es public

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint de prueba
    @GetMapping("/test")
    public String test() {
        return "MoodByteAPI funcionando";
    }

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioService.listar().stream().map(UsuarioDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.crear(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Long id) {
        usuarioService.modificar(usuario, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}