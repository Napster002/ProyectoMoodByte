package org.example.servicio;

import org.example.Modelo.Frase;
import org.example.Modelo.Musica;

import java.util.List;

public class FraseService implements IFraseService<Frase,Long> {
    private FraseRepository repository;

    public FraseService(FraseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Frase crear(Frase frase) {
        return repository.save(frase);
    }

    @Override
    public Frase modificar(Frase frase, Long id) {
        Frase frases=repository.findById(id).orElse(null);
        if(frases!=null){
           frases.setFrase(frase.getFrase());
           frases.setPuntuacion(frase.getPuntuacion());
        }
        return repository.save(frases);
    }

    @Override
    public List<Frase> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Frase buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
