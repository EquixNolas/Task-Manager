package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class AbstractDaoImpl {
	protected static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TASKMANAGER");;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected Query query;
	protected String jpql;
	
	
	public AbstractDaoImpl() {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void close() {
		if (em != null && em.isOpen())
			em.close();
	}
	
	public static void shutdown() {
		if (emf != null && emf.isOpen())
			emf.close();
	}
}
