package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;
import model.Profesor;
public class ControladorMateria {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	

	
	/**
	 * 
	 * 
	 */
	public static List<Materia> findAllProvincias(){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);

		
		List<Materia> l = (List<Materia>) q.getResultList();
		
		em.close();
		return l;
		
	}
}
