package org.example.servicio;

import org.example.Modelo.Estado;
import org.example.Modelo.Frase;

import java.util.List;

public class EstadoService implements IEstadoService<Estado,Long>{
    private EstadoRepository repository;

    public EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Estado crear(Estado estado) {
        return repository.save(estado);
    }

    @Override
    public Estado modificar(Estado estado, Long id) {
        Estado estado1=repository.findById(id).orElse(null);
        if(estado1!=null){
           estado1.setNombre(estado.getNombre());
        }
        return repository.save(estado1);
    }

    @Override
    public List<Estado> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Estado buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
