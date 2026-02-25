package org.example.Conexion;

import org.example.Modelo.Registro;
import org.example.Modelo.Usuario;
import org.example.ModeloDTO.RegistroDTO;
import org.example.ModeloDTO.UsuarioDTO;
import org.example.servicio.RegistroService;
import org.example.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/registro")
public class RegistroController {
    private final RegistroService registroService;
    private final UsuarioService usuarioService;
    @Autowired
    public RegistroController(RegistroService registroService, UsuarioService usuarioService){
        this.registroService=registroService;
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public List<RegistroDTO> findAll(){
        return registroService.listar().stream().map(RegistroDTO::new).toList();
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RegistroDTO registroDto){
        Usuario usuario=usuarioService.buscar(registroDto.idUsuario());
        Registro registro=new Registro();
        registro.setFechaRegistro(registroDto.fechaRegistro());
        registro.setPuntuacion(registroDto.puntuacion());
        registro.setUsuario(usuario);
        Registro creado=registroService.crear(registro);
        return ResponseEntity.ok().build();
    }
}
