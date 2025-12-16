package Interfaz;

import Conexion.ConexionMysqlEMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class InterfazImpl<T,K> implements InterfazGenerica<T,K> {
    protected Class<T>clase;
    protected EntityManagerFactory emf;

    public InterfazImpl(Class<T> clase){
        this.clase=clase;
        this.emf= ConexionMysqlEMF.getEmf();
    }

public void insertar(T t){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
}

public void actualizar(T t){
    EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
}

public T buscarPorId(K k){
    EntityManager em=emf.createEntityManager();
        T instancia=em.find(clase,k);
        em.close();
        return instancia;
}

public void borrarPorId(K k){
    EntityManager em=emf.createEntityManager();
        T instancia=em.find(clase,k);
        if(instancia!=null){
            em.remove(instancia);
        }
        em.close();
}

public List<T> listar(){
        EntityManager em= emf.createEntityManager();
        TypedQuery<T> query=em.createQuery("SELECT t FROM "+clase.getSimpleName()+" t",clase);
        List<T>lista=query.getResultList();
        em.close();
        return lista;
}

}
