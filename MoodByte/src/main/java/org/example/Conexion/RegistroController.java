package org.example.Conexion;

import org.example.Modelo.Registro;
import org.example.Modelo.Usuario;
import org.example.ModeloDTO.RegistroDTO;
import org.example.servicio.RegistroService;
import org.example.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public Registro create(@RequestBody RegistroDTO registroDto){
        Usuario usuario=usuarioService.buscar(registroDto.idUsuario());
        Registro registro=new Registro();
        registro.setFechaRegistro(registroDto.fechaRegistro());
        registro.setPuntuacion(registroDto.puntuacion());
        registro.setUsuario(usuario);
        return registroService.crear(registro);
    }
}
