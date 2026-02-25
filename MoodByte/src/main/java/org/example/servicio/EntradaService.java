package org.example.servicio;

import org.example.Logica.DiarioRepository;
import org.example.Logica.EntradaRepository;
import org.example.Modelo.Diario;
import org.example.Modelo.Entrada;
import org.example.ModeloDTO.EntradaCreateDTO;
import org.example.ModeloDTO.EntradaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService implements IEntradaService<Entrada,Long> {

    private final EntradaRepository repository;
    private final DiarioRepository diarioRepository;

    public EntradaService(EntradaRepository repository, DiarioRepository diarioRepository) {
        this.repository = repository;
        this.diarioRepository = diarioRepository;
    }

    public Entrada create(EntradaCreateDTO dto) {
        Diario diario = diarioRepository.findById(dto.idDiario())
                .orElseThrow(() -> new RuntimeException("Diario no encontrado"));

        Entrada entrada = new Entrada();
        entrada.setId(dto.id());
        entrada.setTexto(dto.texto());
        entrada.setFechaEntrada(dto.fechaEntrada());
        entrada.setDiario(diario);

        return repository.save(entrada);
    }

    public Entrada update(EntradaCreateDTO dto, Long id) {
        Entrada entrada = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada"));

        Diario diario = diarioRepository.findById(dto.idDiario())
                .orElseThrow(() -> new RuntimeException("Diario no encontrado"));

        entrada.setTexto(dto.texto());
        entrada.setFechaEntrada(dto.fechaEntrada());
        entrada.setDiario(diario);

        return repository.save(entrada);
    }

    @Override
    public Entrada crear(Entrada entrada) {
        return null;
    }

    @Override
    public Entrada modificar(Entrada entrada, Long id) {
        return null;
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

    public List<Entrada> listarPorUsuario(Long idUsuario) {
        return repository.findByDiarioIdUsuario(idUsuario);
    }
}
