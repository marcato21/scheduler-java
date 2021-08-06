package main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import main.model.Person;

@Entity
@Table(name = "person_attendance_detail")
public class PersonAttendanceDetail {

	@Id
	@Column(name = "id")
	private String id;
	
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	@OneToOne
	private Person person;
	
	@Column(name = "attendance_date")
	private LocalDate attendanceDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
}
