package org.example.Conexion;

import org.example.Modelo.Entrada;
import org.example.ModeloDTO.EntradaCreateDTO;
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
    public EntradaDTO create(@RequestBody EntradaCreateDTO entrada) {
        return new EntradaDTO(entradaService.create(entrada));
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
    public EntradaDTO update(@RequestBody EntradaCreateDTO dto, @PathVariable Long id) {
        return new EntradaDTO(entradaService.update(dto, id));
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
