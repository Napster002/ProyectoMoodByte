package org.example.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        uniqueConstraints = {@UniqueConstraint(columnNames={"id_usuario","fechaRegistro"})}
)
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int puntuacion;
    private LocalDate fechaRegistro;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Registro() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
