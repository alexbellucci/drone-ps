package br.com.drone.marte.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManager manager;
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("drone-marte");

	public static EntityManager getManager() {
		if (manager == null) manager = factory.createEntityManager();
		
		return manager;
	}
}