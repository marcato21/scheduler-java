package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.PersonDao;
import main.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	public List<Person> getAll() {
		return personDao.getAll();
	}
	
	public Person getById(String id) {
		return personDao.getById(id);
	}
	
	public void insert(Person person) {
		personDao.insert(person);
	}
	
	public void update(Person person) {
		personDao.update(person);
	}
	
	public void delete(String id) {
		personDao.delete(id);
	}
}
