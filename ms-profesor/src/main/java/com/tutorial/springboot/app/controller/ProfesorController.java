package com.tutorial.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.app.entity.Profesor;
import com.tutorial.springboot.app.entity.exceptions.ResourceNotFoundException;
import com.tutorial.springboot.app.repository.ProfesorRepository;

@RestController
@RequestMapping("/api/v1/profesor")
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@GetMapping
	public List<Profesor> all(){
		return profesorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Profesor> getId(@PathVariable(value= "id") Long id) throws ResourceNotFoundException{
		
		Profesor p = profesorRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Profesor no encontrado con este id: "+ id));
		return ResponseEntity.ok(p);
	}
	@PostMapping()
	public Profesor create(@Validated @RequestBody Profesor p) {
		Profesor nuevo =  profesorRepository.save(p);
		return nuevo;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Profesor> update(@PathVariable(value = "id") Long id,
			@Validated @RequestBody Profesor p) throws ResourceNotFoundException{
			Profesor employee = profesorRepository.findById(id)
		    .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con el id :  :" + id)); 		
		    
		    employee.setFirstName(p.getFirstName());
		    employee.setLastName(p.getLastName());
		    employee.setEmail(p.getEmail());
		    
		    final Profesor updateProfesor = profesorRepository.save(employee);
		    return ResponseEntity.ok(updateProfesor);
		    
		    	
	}
}
