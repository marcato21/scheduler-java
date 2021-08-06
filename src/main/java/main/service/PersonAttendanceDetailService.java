package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.PersonAttendanceDetailDao;
import main.model.PersonAttendanceDetail;

@Service
public class PersonAttendanceDetailService {

	@Autowired
	private PersonAttendanceDetailDao personAttendanceDetailDao;
	
	public List<PersonAttendanceDetail> getAll() {
		return personAttendanceDetailDao.getAll();
	}
	
	public List<PersonAttendanceDetail> getAllByPersonId(String personId) {
		return personAttendanceDetailDao.getAllByPersonId(personId);
	}
	
	public PersonAttendanceDetail getById(String id) {
		return personAttendanceDetailDao.getById(id);
	}
	
	public void insert(PersonAttendanceDetail personAttendanceDetail) {
		personAttendanceDetailDao.insert(personAttendanceDetail);
	}
	
	public void update(PersonAttendanceDetail personAttendanceDetail) {
		personAttendanceDetailDao.update(personAttendanceDetail);
	}
	
	public void delete(String id) {
		personAttendanceDetailDao.delete(id);
	}
	
	public void deleteByPerson(String personId) {
		personAttendanceDetailDao.deleteByPerson(personId);;
	}
}
