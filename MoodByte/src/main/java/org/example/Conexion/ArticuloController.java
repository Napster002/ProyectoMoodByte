package org.example.Conexion;

import org.example.Modelo.Articulo;
import org.example.Modelo.Usuario;
import org.example.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/articulo")
class ArticuloController {
    private ArticuloService articuloService;
    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }
    @PostMapping
    public Articulo create(@RequestBody Articulo articulo) {
        return articuloService.crear(articulo);
    }
    @GetMapping
    public List<Articulo> findAll() {
        return articuloService.listar();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articuloService.eliminar(id);
    }
    @PutMapping("/{id}")
    public Articulo update(@RequestBody Articulo articulo, @PathVariable Long id) {
        return articuloService.modificar(articulo, id);
    }
    @GetMapping("/{id}")
    public Articulo findById(@PathVariable Long id) {
        return articuloService.buscar(id);
    }
}
