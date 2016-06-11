package br.com.crescer.aula4.hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO implements IDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static EntityManager em;

    @Override
    public void save(Object object) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<?> listAll(Class classe) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT item FROM " + classe.getName() + " item");
        List<?> lista = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return lista;
    }

    @Override
    public void update(Object object) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Object object) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(object));
        em.getTransaction().commit();
        em.close();
    }

}
