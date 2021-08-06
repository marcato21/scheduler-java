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

import main.model.Person;
import main.service.PersonService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@Controller
@RestController
@RequestMapping({ "/api/test" })
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/persons")
	public ResponseEntity<?> getAll() throws Exception {
		return ResponseEntity.ok(personService.getAll());
	}

	@GetMapping(value = "/person/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) throws Exception {
		try {
			return ResponseEntity.ok(personService.getById(id));			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
		}
	}
	
	@PostMapping(value = "/person")
	public ResponseEntity<?> insert(@RequestBody Person person) throws Exception {
		try {
			personService.insert(person);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@PutMapping(value = "/person")
	public ResponseEntity<?> update(@RequestBody Person person) throws Exception {
		try {
			personService.update(person);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping(value = "/person/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
		try {
			personService.delete(id);
			return ResponseEntity.ok(HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
}
