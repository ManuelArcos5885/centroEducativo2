package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Profesor;
public class ControladorProfesor {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	

	
	/**
	 * 
	 * 
	 */
	public static List<Profesor> findAllProvincias(){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);

		
		List<Profesor> l = (List<Profesor>) q.getResultList();
		
		em.close();
		return l;
		
	}
}
