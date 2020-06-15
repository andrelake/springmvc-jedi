package com.andrelake.diospringmvcjedi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrelake.diospringmvcjedi.model.Jedi;
import com.andrelake.diospringmvcjedi.service.JediService;

@RestController
public class JediResource {

	@Autowired
	private JediService service;

	@GetMapping("/api/jedi")
	public List<Jedi> getAllJedi() {

		return service.findAll();
	}

	@GetMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable Long id) {

		final Jedi jedi = service.findById(id);

		return ResponseEntity.ok(jedi);
	}

	@PostMapping("/api/jedi")
	public ResponseEntity<Jedi> addJedi(@Valid @RequestBody Jedi jedi) {

		service.save(jedi);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> updateJedi(@PathVariable Long id, @Valid @RequestBody Jedi jedi) {

		final Jedi jedi2 = service.update(id, jedi);
		
		return ResponseEntity.ok(jedi2);
	}

	@DeleteMapping("/api/jedi/{id}")
	public ResponseEntity<Void> deleteJedi(@PathVariable Long id) {

		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
