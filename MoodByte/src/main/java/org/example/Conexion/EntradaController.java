package org.example.Conexion;

import org.example.Modelo.Entrada;
import org.example.ModeloDTO.EntradaDTO;
import org.example.servicio.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrada")
public class EntradaController {

    private final EntradaService entradaService;

    @Autowired
    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @PostMapping
    public Entrada create(@RequestBody Entrada entrada) {
        return entradaService.crear(entrada);
    }

    @GetMapping
    public List<EntradaDTO> findAll() {
        return entradaService.listar()
                .stream()
                .map(EntradaDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public Entrada findById(@PathVariable Long id) {
        return entradaService.buscar(id);
    }

    @PutMapping("/{id}")
    public Entrada update(@RequestBody Entrada entrada, @PathVariable Long id) {
        return entradaService.modificar(entrada, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entradaService.eliminar(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<EntradaDTO> findByUsuario(@PathVariable Long idUsuario) {
        return entradaService.listarPorUsuario(idUsuario)
                .stream()
                .map(EntradaDTO::new)
                .toList();
    }
}
