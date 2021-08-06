package main.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import main.dao.PersonAttendanceDao;
import main.model.PersonAttendance;

@Service
public class PersonAttendanceService {

	@Autowired
	private PersonAttendanceDao personAttendanceDao;
	
    private static final Logger logger = LoggerFactory.getLogger(PersonAttendanceService.class);
	
	public List<PersonAttendance> getAll() {
		return personAttendanceDao.getAll();
	}
	
	public List<PersonAttendance> getAllByPersonId(String personId) {
		return personAttendanceDao.getAllByPersonId(personId);
	}
	
	public PersonAttendance getById(String id) {
		return personAttendanceDao.getById(id);
	}
	
	public void insert(PersonAttendance personAttendance) {
		personAttendanceDao.insert(personAttendance);
	}
	
	public void update(PersonAttendance personAttendance) {
		personAttendanceDao.update(personAttendance);
	}
	
	@Scheduled(cron="0 0 0 * * *", zone="Asia/Jakarta")
	public void updateAttendance() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		logger.info("Scheduled Update Attendance Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		personAttendanceDao.updateAttendance();
	}
	
	public void delete(String id) {
		personAttendanceDao.delete(id);
	}
	
	public void deleteByPerson(String personId) {
		personAttendanceDao.deleteByPerson(personId);;
	}
}
