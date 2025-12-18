package org.example.Logica;

import Conexion.ConexionMysqlEMF;
import Interfaz.InterfazImpl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Estado;
import org.example.Modelo.Musica;

import java.util.List;

public class EstadoDAO extends InterfazImpl<Estado,Integer> {
    public EstadoDAO() {super(Estado.class);}
    public List<Ejercicio> crearEjercicios(Estado estado){
        List<Ejercicio> ejercicios;
        EntityManager em=null;
        try{
            em= ConexionMysqlEMF.getEmf().createEntityManager();
            TypedQuery<Ejercicio> query=em.createQuery("SELECT e FROM Ejercicio e where e.estado.id = :idEstado",Ejercicio.class);
            query.setParameter("idEstado",estado.getId());
            ejercicios=query.getResultList();
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return ejercicios;
    }
    public List<Musica> crearMusica(Estado estado){
        List<Musica> musicas;
        EntityManager em=null;
        try{
            em= ConexionMysqlEMF.getEmf().createEntityManager();
            TypedQuery<Musica> query=em.createQuery("SELECT m FROM Musica m where m.estado.id = :idEstado", Musica.class);
            query.setParameter("idEstado",estado.getId());
            musicas=query.getResultList();
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return musicas;
    }
}
