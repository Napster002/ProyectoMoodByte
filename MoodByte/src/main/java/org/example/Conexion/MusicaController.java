package org.example.Conexion;

import org.example.Modelo.Articulo;
import org.example.Modelo.Musica;
import org.example.servicio.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musica")
class MusicaController {
    private MusicaService musicaService;
    @Autowired
    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }
    @PostMapping
    public Musica create(@RequestBody Musica musica) {
        return musicaService.crear(musica);
    }
    @GetMapping
    public List<Musica> findAll() {
        return musicaService.listar();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musicaService.eliminar(id);
    }
    @PutMapping("/{id}")
    public Musica update(@RequestBody Musica musica, @PathVariable Long id) {
        return musicaService.modificar(musica, id);
    }
    @GetMapping("/{id}")
    public Musica findById(@PathVariable Long id) {
        return musicaService.buscar(id);
    }
}
