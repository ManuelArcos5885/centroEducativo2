package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;
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
	 * 
	 * 
	 */
	
	
}
