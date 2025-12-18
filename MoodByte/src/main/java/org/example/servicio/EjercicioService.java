package org.example.servicio;

import org.example.Logica.EjercicioRepository;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Entrada;

import java.util.List;

public class EjercicioService implements IEjercicioService<Ejercicio,Long>{
    private EjercicioRepository repository;

    public EjercicioService(EjercicioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ejercicio crear(Ejercicio ejercicio) {
        return repository.save(ejercicio);
    }

    @Override
    public Ejercicio modificar(Ejercicio ejercicio, Long id) {
        Ejercicio ejer=repository.findById(id).orElse(null);
        if(ejer!=null){
            ejer.setDescripcion(ejercicio.getDescripcion());
            ejer.setDuracion(ejercicio.getDuracion());
            ejer.setTitulo(ejercicio.getTitulo());
        }
        return repository.save(ejer);
    }

    @Override
    public List<Ejercicio> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Ejercicio buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
