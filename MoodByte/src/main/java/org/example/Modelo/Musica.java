package org.example.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name="musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String enlace;
    @ManyToOne
    private Estado estado;

    public Musica() { }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getEnlace() {return enlace;}

    public void setEnlace(String enlace) {this.enlace = enlace;}
}
