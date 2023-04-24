package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;
public class ControladorAlumno {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	

	
	/**
	 * 
	 * 
	 */
	public static List<Estudiante> findAllProvincias(){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);

		
		List<Estudiante> l = (List<Estudiante>) q.getResultList();
		
		em.close();
		return l;
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	/**
	 * 
	 * 
	 */
	public static Estudiante findById(int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Estudiante l = (Estudiante) em.find(Estudiante.class, id);
		
		em.close();
		return l;
		
	}
}
