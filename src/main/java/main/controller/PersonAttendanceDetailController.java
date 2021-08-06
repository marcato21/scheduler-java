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

import main.model.PersonAttendanceDetail;
import main.service.PersonAttendanceDetailService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@Controller
@RestController
@RequestMapping({ "/api/test" })
public class PersonAttendanceDetailController {

	@Autowired
	private PersonAttendanceDetailService personAttendanceDetailService;
	
	@GetMapping(value = "/attendance/details")
	public ResponseEntity<?> getAll() throws Exception {
		return ResponseEntity.ok(personAttendanceDetailService.getAll());
	}
	
	@GetMapping(value = "/attendance/details/person/{personId}")
	public ResponseEntity<?> getAllByPersonId(@PathVariable String personId) throws Exception {
		try {
			return ResponseEntity.ok(personAttendanceDetailService.getAllByPersonId(personId));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
		}
	}

	@GetMapping(value = "/attendance/detail/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) throws Exception {
		try {
			return ResponseEntity.ok(personAttendanceDetailService.getById(id));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
		}
	}
	
	@PostMapping(value = "/attendance/detail")
	public ResponseEntity<?> insert(@RequestBody PersonAttendanceDetail personAttendanceDetail) throws Exception {
		try {
			personAttendanceDetailService.insert(personAttendanceDetail);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@PutMapping(value = "/attendance/detail")
	public ResponseEntity<?> update(@RequestBody PersonAttendanceDetail personAttendanceDetail) throws Exception {
		try {
			personAttendanceDetailService.update(personAttendanceDetail);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping(value = "/attendance/detail/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
		try {
			personAttendanceDetailService.delete(id);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping(value = "/attendance/details/person/{personId}")
	public ResponseEntity<?> deleteByPerson(@PathVariable String personId) throws Exception {
		try {
			personAttendanceDetailService.deleteByPerson(personId);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
}
