package org.example.servicio;

import org.example.Logica.MusicaRepository;
import org.example.Modelo.Musica;
import org.example.Modelo.Registro;

import java.util.List;

public class MusicaService implements IMusicaService<Musica,Long>{
    private MusicaRepository repository;

    public MusicaService(MusicaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Musica crear(Musica musica) {
        return repository.save(musica);
    }

    @Override
    public Musica modificar(Musica musica, Long id) {
        Musica music=repository.findById(id).orElse(null);
        if(music!=null){
            music.setEnlace(music.getEnlace());
        }
        return repository.save(music);
    }

    @Override
    public List<Musica> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Musica buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
