package Conexion;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionMysqlEMF {
    private static EntityManagerFactory emf;
    private ConexionMysqlEMF() {
        int cont=0;
        emf= Persistence.createEntityManagerFactory("MoodBytePersistence");
        cont++;
        if(cont==1){
            System.out.println("Se conecto a la base de datos correctamnete");
        }
    }
    public static EntityManagerFactory getEmf() {
        if(emf==null){
            new ConexionMysqlEMF();
        }
        return emf;
    }
    public boolean cerrar(){
        boolean isOpen=false;
        if(emf!=null){
           emf.close();
           isOpen=true;
        }
        return isOpen;
    }
}
