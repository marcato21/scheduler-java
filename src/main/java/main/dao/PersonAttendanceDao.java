package main.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import main.model.PersonAttendance;

@Repository
@Transactional
public class PersonAttendanceDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public List<PersonAttendance> getAll() {
		EntityManager em = emf.createEntityManager();
		List<PersonAttendance> result = em.createQuery("FROM PersonAttendance")
				.getResultList();
		
		if(result.size() == 0) {
			return new ArrayList<PersonAttendance>();
		} else {
			return result;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PersonAttendance> getAllByPersonId(String personId) {
		EntityManager em = emf.createEntityManager();
		List<PersonAttendance> result = em.createQuery("FROM PersonAttendance WHERE person.id = :personId ")
				.setParameter("personId", personId)
				.getResultList();
		
		if(result.size() == 0) {
			return new ArrayList<PersonAttendance>();
		} else {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	public PersonAttendance getById(String id) {
		EntityManager em = emf.createEntityManager();
		List<PersonAttendance> result = em.createQuery("From PersonAttendance WHERE id = :id ")
				.setParameter("id", id)
				.getResultList();
		
		if(result.size() == 0) {
			return new PersonAttendance();
		} else {
			return result.get(0);
		}
	}
	
	public void insert(PersonAttendance personAttendance) {
		EntityManager em = emf.createEntityManager();
		em.persist(personAttendance);
	}
	
	public void update(PersonAttendance personAttendance) {
		EntityManager em = emf.createEntityManager();
		em.merge(personAttendance);
	}
	
	@SuppressWarnings("unused")
	public void updateAttendance() {
		EntityManager em = emf.createEntityManager();
		List<Object> result = em.createNativeQuery("SELECT update_attendance() ").getResultList();
	}
	
	public void delete(String id) {
		EntityManager em = emf.createEntityManager();
		em.createNativeQuery("DELETE FROM person_attendance WHERE id = :id ")
			.setParameter("id", id)
			.executeUpdate();
	}
	
	public void deleteByPerson(String personId) {
		EntityManager em = emf.createEntityManager();
		em.createNativeQuery("DELETE FROM person_attendance WHERE person_id = :personId ")
			.setParameter("personId", personId)
			.executeUpdate();
	}
}
