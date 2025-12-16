package Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length=50,nullable = false)
    private String nombreCompleto;
    @Column(length=20,nullable = false)
    private String nombreUsuario;
    @Column(length=20,nullable = false)
    private String password;
    private int edad;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    private LocalDate fechaRegistro;
    private LocalDate fechaNacimiento;
    private int nivel;
    private double expAcumulada;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Registro> registros=new ArrayList<>();
    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
    private Diario diario;

    public Usuario() {
        this.fechaRegistro=LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getExpAcumulada() {
        return expAcumulada;
    }

    public void setExpAcumulada(double expAcumulada) {
        this.expAcumulada = expAcumulada;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    public void addRegistro(Registro registro){
        this.registros.add(registro);
        registro.setUsuario(this);
    }

    public void removeRegistro(Registro registro){
        this.registros.remove(registro);
        registro.setUsuario(null);
    }

}
