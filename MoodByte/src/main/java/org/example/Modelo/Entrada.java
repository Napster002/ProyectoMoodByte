package org.example.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "entradas",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"idDiario", "fechaEntrada"})
        }
)
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String texto;
    private LocalDate fechaEntrada;
    @ManyToOne
    @JoinColumn(name="idDiario")
    private Diario diario;

    public Entrada() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }
}
