package org.example.servicio;

import org.example.Logica.EntradaRepository;
import org.example.Modelo.Entrada;
import org.example.Modelo.Estado;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntradaService implements IEntradaService<Entrada,Long>{
    private EntradaRepository repository;

    public EntradaService(EntradaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Entrada crear(Entrada entrada) {
        return repository.save(entrada);
    }

    @Override
    public Entrada modificar(Entrada entrada, Long id) {
        Entrada entrada1=repository.findById(id).orElse(null);
        if(entrada1!=null){
           entrada1.setTexto(entrada.getTexto());
           entrada1.setDiario(entrada.getDiario());
           entrada1.setFechaEntrada(entrada.getFechaEntrada());
        }
        return repository.save(entrada1);
    }

    @Override
    public List<Entrada> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Entrada buscar(Long id) {
        return repository.findById(id).orElse(null);
    }
}
