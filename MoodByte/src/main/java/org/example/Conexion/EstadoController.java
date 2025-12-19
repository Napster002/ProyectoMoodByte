package org.example.Conexion;

import org.example.Modelo.Estado;
import org.example.servicio.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    private EstadoService estadoService;
    @Autowired
    public EstadoController(EstadoService estadoService) {this.estadoService = estadoService;}
    @PostMapping
    public Estado create(@RequestBody Estado estado) {
        return estadoService.crear(estado);
    }
    @GetMapping
    public List<Estado> findAll() {
        return estadoService.listar();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estadoService.eliminar(id);
    }
    @PutMapping("/{id}")
    public Estado update(@RequestBody Estado estado, @PathVariable Long id) {
        return estadoService.modificar(estado, id);
    }
    @GetMapping("/{id}")
    public Estado findById(@PathVariable Long id) {
        return estadoService.buscar(id);
    }
}
