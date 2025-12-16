package Modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="diarios")
public class Diario {
    @Id
    private long idUsuario;
    @OneToOne
    @MapsId
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "diario")
    private List<Entrada> entradas=new ArrayList<>();

    public Diario() {
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void addEntrada(Entrada entrada){
        this.entradas.add(entrada);
        entrada.setDiario(this);
    }

    public void removeEntrada(Entrada entrada){
        this.entradas.remove(entrada);
        entrada.setDiario(null);
    }
}
