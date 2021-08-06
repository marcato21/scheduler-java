package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.PersonAttendance;
import main.service.PersonAttendanceService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@Controller
@RestController
@RequestMapping({ "/api/test" })
public class PersonAttendanceController {

	@Autowired
	private PersonAttendanceService personAttendanceService;
	
	@GetMapping(value = "/attendances")
	public ResponseEntity<?> getAll() throws Exception {
		return ResponseEntity.ok(personAttendanceService.getAll());
	}
	
	@GetMapping(value = "/attendances/person/{personId}")
	public ResponseEntity<?> getAllByPersonId(@PathVariable String personId) throws Exception {
		try {
			return ResponseEntity.ok(personAttendanceService.getAllByPersonId(personId));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
		}
	}

	@GetMapping(value = "/attendance/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) throws Exception {
		try {
			return ResponseEntity.ok(personAttendanceService.getById(id));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
		}
	}
	
	@PostMapping(value = "/attendance")
	public ResponseEntity<?> insert(@RequestBody PersonAttendance personAttendance) throws Exception {
		try {
			personAttendanceService.insert(personAttendance);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@PutMapping(value = "/attendance")
	public ResponseEntity<?> update(@RequestBody PersonAttendance personAttendance) throws Exception {
		try {
			personAttendanceService.update(personAttendance);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping(value = "/attendance/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
		try {
			personAttendanceService.delete(id);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping(value = "/attendances/person/{personId}")
	public ResponseEntity<?> deleteByPerson(@PathVariable String personId) throws Exception {
		try {
			personAttendanceService.deleteByPerson(personId);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
}
