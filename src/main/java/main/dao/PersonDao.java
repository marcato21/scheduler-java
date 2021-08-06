package main.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Person;

@Repository
@Transactional
public class PersonDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		EntityManager em = emf.createEntityManager();
		List<Person> result = em.createQuery("From Person")
				.getResultList();
		
		if(result.size() == 0) {
			return new ArrayList<Person>();
		} else {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	public Person getById(String id) {
		EntityManager em = emf.createEntityManager();
		List<Person> result = em.createQuery("From Person WHERE id = :id ")
				.setParameter("id", id)
				.getResultList();
		
		if(result.size() == 0) {
			return new Person();
		} else {
			return result.get(0);
		}
	}
	
	public void insert(Person person) {
		EntityManager em = emf.createEntityManager();
		em.persist(person);
	}
	
	public void update(Person person) {
		EntityManager em = emf.createEntityManager();
		em.merge(person);
	}
	
	public void delete(String id) {
		EntityManager em = emf.createEntityManager();
		em.createNativeQuery("DELETE FROM person WHERE id = :id ")
			.setParameter("id", id)
			.executeUpdate();
	}
}
