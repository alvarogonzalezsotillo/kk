package miweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

public class MiDAO{
    private static EntityManagerFactory _emf;
    public static String DATASOURCE = "ejemplo-derby";
    private static EntityManager _em;


    public static void init(){
        if( _emf == null ){
            _emf = Persistence.createEntityManagerFactory(DATASOURCE);
            _em = _emf.createEntityManager();
        }
    }

    public static EntityManager entityManager(){
        init();
        return _em;
    }

    public static Cliente insertaCliente(Cliente c){
        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(c);

        tx.commit();

        return c;

    }

    public static Cliente actualizaCliente(Cliente c){
        return insertaCliente(c);
    }

    public static List<Cliente> todosLosClientes(){
        EntityManager em = entityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("FROM Cliente");
        
        @SuppressWarnings("unchecked") 
        List<Cliente> clientes = query.getResultList();
        tx.commit();
        return clientes;
    }

    public static void borraCliente(Cliente c){
        System.out.println( "Acabar de borrar cliente:" + c );
    }
}
