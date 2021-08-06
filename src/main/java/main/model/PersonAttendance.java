package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import main.model.Person;

@Entity
@Table(name = "person_attendance")
public class PersonAttendance {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	@OneToOne
	private Person person;
	
	@Column(name = "scheduled_att")
	private Integer scheduledAtt;
	
	@Column(name = "real_att")
	private Integer realAtt;
	
	@Column(name = "month")
	private Integer month;
	
	@Column(name = "year")
	private Integer year;

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

	public Integer getScheduledAtt() {
		return scheduledAtt;
	}

	public void setScheduledAtt(Integer scheduledAtt) {
		this.scheduledAtt = scheduledAtt;
	}

	public Integer getRealAtt() {
		return realAtt;
	}

	public void setRealAtt(Integer realAtt) {
		this.realAtt = realAtt;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
