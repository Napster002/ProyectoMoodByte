package Logica;

import Conexion.ConexionMysqlEMF;
import Interfaz.InterfazImpl;
import Modelo.Entrada;
import Modelo.Registro;
import Modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends InterfazImpl<Usuario,Integer> {
    public UsuarioDAO() {
        super(Usuario.class);
    }
    public List<Registro> mostrarRegistros(Usuario usuario){
        List<Registro> registros;
        EntityManager em =null;
        try {
            em=ConexionMysqlEMF.getEmf().createEntityManager();
            TypedQuery<Registro> query =em.createQuery("SELECT r FROM Registro r where r.usuario.id = :idUsuario",Registro.class);
            query.setParameter("idUsuario",usuario.getId());
            registros=query.getResultList();
        } finally{
            if(em!=null){
                em.close();
            }
        }
        return registros;
    }
    public List<Entrada> mostrarEntradas(Usuario usuario){
        List<Entrada> entradas;
        EntityManager em=null;
        try{
            em=ConexionMysqlEMF.getEmf().createEntityManager();
            TypedQuery<Entrada> query=em.createQuery("SELECT e FROM Entrada e where e.diario.id = :idUsuario",Entrada.class);
            query.setParameter("idUsuario",usuario.getId());
            entradas=query.getResultList();
        }finally{
            if(em!=null){
                em.close();
            }
        }
        return entradas;
    }
}
