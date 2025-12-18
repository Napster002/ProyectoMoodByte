package org.example.servicio;

import org.example.Modelo.Articulo;
import org.example.Modelo.Ejercicio;

import java.util.List;

public class ArticuloService implements IArticuloService<Articulo,Long>{
    private ArticuloRepository repository;

    public ArticuloService(ArticuloRepository repository) {
        this.repository = repository;
    }

    @Override
    public Articulo crear(Articulo articulo) {
        return repository.save(articulo);
    }

    @Override
    public Articulo modificar(Articulo articulo, Long id) {
        Articulo articulo1=repository.findById(id).orElse(null);
        if(articulo1!=null){
           articulo1.setEnlace(articulo.getEnlace());
           articulo1.setImagen(articulo.getImagen());
           articulo1.setTitulo(articulo1.getTitulo());
           articulo1.setSubtitulo(articulo1.getSubtitulo());
        }
        return repository.save(articulo1);
    }

    @Override
    public List<Articulo> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Articulo buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
