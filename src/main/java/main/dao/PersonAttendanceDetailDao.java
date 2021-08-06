package main.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.PersonAttendanceDetail;

@Repository
@Transactional
public class PersonAttendanceDetailDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public List<PersonAttendanceDetail> getAll() {
		EntityManager em = emf.createEntityManager();
		List<PersonAttendanceDetail> result = em.createQuery("FROM PersonAttendanceDetail")
				.getResultList();
		
		if(result.size() == 0) {
			return new ArrayList<PersonAttendanceDetail>();
		} else {
			return result;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PersonAttendanceDetail> getAllByPersonId(String personId) {
		EntityManager em = emf.createEntityManager();
		List<PersonAttendanceDetail> result = em.createQuery("FROM PersonAttendanceDetail WHERE person.id = :personId ")
				.setParameter("personId", personId)
				.getResultList();
		
		if(result.size() == 0) {
			return new ArrayList<PersonAttendanceDetail>();
		} else {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	public PersonAttendanceDetail getById(String id) {
		EntityManager em = emf.createEntityManager();
		List<PersonAttendanceDetail> result = em.createQuery("From PersonAttendanceDetail WHERE id = :id ")
				.setParameter("id", id)
				.getResultList();
		
		if(result.size() == 0) {
			return new PersonAttendanceDetail();
		} else {
			return result.get(0);
		}
	}
	
	public void insert(PersonAttendanceDetail personAttendanceDetail) {
		EntityManager em = emf.createEntityManager();
		em.persist(personAttendanceDetail);
	}
	
	public void update(PersonAttendanceDetail personAttendanceDetail) {
		EntityManager em = emf.createEntityManager();
		em.merge(personAttendanceDetail);
	}
	
	public void delete(String id) {
		EntityManager em = emf.createEntityManager();
		em.createNativeQuery("DELETE FROM person_attendance_detail WHERE id = :id ")
			.setParameter("id", id)
			.executeUpdate();
	}
	
	public void deleteByPerson(String personId) {
		EntityManager em = emf.createEntityManager();
		em.createNativeQuery("DELETE FROM person_attendance_detail WHERE person_id = :personId ")
			.setParameter("personId", personId)
			.executeUpdate();
	}
}
