package org.example.Modelo;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name="ejercicio")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 30)
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(length = 255)
    private String recursoUrl;
    private Time duracion;
    @ManyToOne
    private Estado estado;

    public Ejercicio() {}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Time getDuracion() {return duracion;}

    public void setDuracion(Time duracion) {this.duracion = duracion;}

    public String getRecursoUrl() {
        return recursoUrl;
    }

    public void setRecursoUrl(String recursoUrl) {
        this.recursoUrl = recursoUrl;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
