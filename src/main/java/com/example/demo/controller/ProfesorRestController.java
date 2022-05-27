package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profesor;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.Mprofesor;
import com.example.demo.service.IProfesorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores(){
		return profesorService.findAll() ;
	}
	@PostMapping("/sing_up")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor){
		if(profesorService.findProfesor(profesor)==null) {
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}		
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable(value ="id")Long id,@RequestBody Profesor profesor){
		
		Profesor profesorDb=null;
		profesorDb = profesorService.findById(id);
		if(profesorDb!=null) {
			profesorDb.setEmail(profesor.getEmail());
			profesorDb.setNombre(profesor.getNombre());
			profesorService.updateProfesor(profesorDb);
			return new ResponseEntity<>(profesorDb,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProfesor(@PathVariable(value ="id")Long id){
		
		profesorService.deleteProfesor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteAllProfesores(){
		profesorService.deleteAllProfesores();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/update_sql")
	public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor){
		
		Profesor profesorDb=null;
		profesorDb = profesorService.findByIdSQL(profesor.getId());
		if(profesorDb!=null) {
			profesorDb.setEmail(profesor.getEmail());
			profesorDb.setNombre(profesor.getNombre());
			profesorService.updateProfesor(profesorDb);
			return new ResponseEntity<>(profesorDb,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
	}
	@PostMapping("/delete_post")
	public ResponseEntity<Void> deletePorfesorPost(@RequestBody Profesor profesor){
		if(profesorService.findById(profesor.getId())!=null) {
			profesorService.deleteProfesor(profesor);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor){
		Profesor ProfesorDb= profesorService.checkProfesorLogin(profesor);
		if(ProfesorDb!=null) {
			List<Profesor> profesores = new ArrayList<>();
			profesores.add(ProfesorDb);
			List<Mprofesor> mProfesores = new ArrayList<>();
			mProfesores = Mapper.convertirLista(profesores);
			
			return new ResponseEntity<>(mProfesores,HttpStatus.OK); 
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}
	
}

