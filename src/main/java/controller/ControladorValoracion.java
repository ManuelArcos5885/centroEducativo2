package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Valoracionmateria;

public class ControladorValoracion {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	

	
	/**
	 * 
	 * 
	 */
	public static Valoracionmateria findById(int idA,int idM,int idP){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		
		try {			
			Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idProfesor = ? and idMateria= ? and idEstudiante= ?", Valoracionmateria.class);
			q.setParameter(1, idA);
			q.setParameter(2, idM);
			q.setParameter(3, idP);
			
			Valoracionmateria res = (Valoracionmateria) q.getSingleResult();
			em.close();
			return res;
		}
		catch (NoResultException nrEx) {
			return null;
		}
		
		
		
		
		
	}
	
	/**
	 * 
	 * actualizar
	 * 
	 */
	public void merge(Valoracionmateria v) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * elije entre actualizar o insertar
	 */
	
	public void save(Valoracionmateria e) {
		EntityManager em = entityManagerFactory.createEntityManager();
		if (e.getId() != 0) {
			merge(e);
		}
		else {
			persist(e);
		}
	}
	
	/**
	 * 
	 * 
	 */
	
	/**
	 * insertar
	 */
	public void persist(Valoracionmateria e) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 */
	public void remove(Valoracionmateria e) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Valoracionmateria actual = null;
		em.getTransaction().begin();
		if (!em.contains(e)) {
			actual = em.merge(e);
		}
		em.remove(actual);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
