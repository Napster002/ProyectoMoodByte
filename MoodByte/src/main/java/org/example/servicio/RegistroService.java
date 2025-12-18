package org.example.servicio;

import org.example.Logica.RegistroRepository;
import org.example.Modelo.Registro;


import java.util.List;

public class RegistroService implements IRegistroService<Registro, Long>{
    private final RegistroRepository repository;

    public RegistroService(RegistroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Registro crear(Registro registro) {
        return repository.save(registro);
    }

    @Override
    public Registro modificar(Registro registro, Long id) {
        Registro regi=repository.findById(id).orElse(null);
        if(regi!=null){
            regi.setPuntuacion(registro.getPuntuacion());
            regi.setFechaRegistro(registro.getFechaRegistro());
        }
        return repository.save(regi);
    }

    @Override
    public List<Registro> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Registro buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
