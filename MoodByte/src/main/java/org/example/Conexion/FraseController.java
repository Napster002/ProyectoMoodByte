package org.example.Conexion;

import org.example.Modelo.Frase;
import org.example.servicio.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/frase")
class FraseController {
    private FraseService fraseService;
    @Autowired
    public FraseController(FraseService fraseService) {
        this.fraseService = fraseService;
    }
    @PostMapping
    public Frase create(@RequestBody Frase frase) {
        return fraseService.crear(frase);
    }
    @GetMapping
    public List<Frase> findAll() {
        return fraseService.listar();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fraseService.eliminar(id);
    }
    @PutMapping("/{id}")
    public Frase update(@RequestBody Frase frase, @PathVariable Long id) {
        return fraseService.modificar(frase, id);
    }
    @GetMapping("/{id}")
    public Frase findById(@PathVariable Long id) {
        return fraseService.buscar(id);
    }
}
