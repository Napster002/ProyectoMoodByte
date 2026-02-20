package org.example.Conexion;

import org.example.Modelo.Registro;
import org.example.servicio.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registro")
public class RegistroController {
    private final RegistroService registroService;
    @Autowired
    public RegistroController(RegistroService registroService){
        this.registroService=registroService;
    }

    @PostMapping
    public Registro create(@RequestBody Registro registro){
        return registroService.crear(registro);
    }
}
