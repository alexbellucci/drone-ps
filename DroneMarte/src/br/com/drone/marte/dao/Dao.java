package br.com.drone.marte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.drone.marte.model.Drone;
import br.com.drone.marte.util.JPAUtil;

public class Dao {

	EntityManager manager = JPAUtil.getManager();
	
	public void criar(Drone drone) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("drone-marte");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(drone);
		manager.getTransaction().commit();
				
		manager.close();
	}
	
	public List<Drone> buscarTodos() {
		TypedQuery<Drone> query = 
				manager.createQuery("SELECT d FROM Drone d", Drone.class);
		return query.getResultList();
	}
	
	public void editar(Drone drone) {
		manager.getTransaction().begin();
		manager.merge(drone);
		manager.getTransaction().commit();
	}
	
	public void apagar(Drone drone) {
		manager.getTransaction().begin();
		manager.remove(drone);
		manager.getTransaction().commit();
	}

	public void apagar(Long id) {
		apagar(buscarPorId(id));
	}

	public Drone buscarPorId(Long id) {
		return manager.find(Drone.class, id);
	}
}
