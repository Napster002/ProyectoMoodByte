package org.example.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name="articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 40)
    private String titulo;
    @Column(length = 60)
    private String subtitulo;
    @Column(columnDefinition = "TEXT")
    private String imagen;
    @Column(columnDefinition = "TEXT")
    private String enlace;

    public Articulo() {}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getSubtitulo() {return subtitulo;}

    public void setSubtitulo(String subtitulo) {this.subtitulo = subtitulo;}

    public String getImagen() {return imagen;}

    public void setImagen(String imagen) {this.imagen = imagen;}

    public String getEnlace() {return enlace;}

    public void setEnlace(String enlace) {this.enlace = enlace;}
}
