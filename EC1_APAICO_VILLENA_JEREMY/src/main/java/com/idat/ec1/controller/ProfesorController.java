package com.idat.ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec1.dto.ProfesorRequestDTO;
import com.idat.ec1.model.Profesor;
import com.idat.ec1.service.ProfesorService;

@RestController
@RequestMapping("/profesor/ec1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<Profesor>>listar(){
		
		return new ResponseEntity<List<Profesor>>(service.listarProfesor(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProfesorRequestDTO profesor){
		service.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Profesor> ProfesorById(@PathVariable Integer id){
		Profesor pro = service.ProfesorById(id);
		if(pro != null) {
			return new ResponseEntity<Profesor>(pro, HttpStatus.OK);

		}
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor pro = service.ProfesorById(id);
		if(pro != null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		Profesor pro = service.ProfesorById(profesor.getIdProfesor());
		if(pro != null) {
			service.editarProfesor(pro);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
