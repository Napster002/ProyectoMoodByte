package org.example.Conexion;

import org.example.Modelo.Ejercicio;
import org.example.servicio.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicio")
class EjercicioController {
    private EjercicioService ejercicioService;
    @Autowired
    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }
    @PostMapping
    public Ejercicio create(@RequestBody Ejercicio ejercicio) {
        return ejercicioService.crear(ejercicio);
    }
    @GetMapping
    public List<Ejercicio> findAll() {
        return ejercicioService.listar();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ejercicioService.eliminar(id);
    }
    @PutMapping("/{id}")
    public Ejercicio update(@RequestBody Ejercicio ejercicio, @PathVariable Long id) {
        return ejercicioService.modificar(ejercicio, id);
    }
    @GetMapping("/{id}")
    public Ejercicio findById(@PathVariable Long id) {
        return ejercicioService.buscar(id);
    }
}
