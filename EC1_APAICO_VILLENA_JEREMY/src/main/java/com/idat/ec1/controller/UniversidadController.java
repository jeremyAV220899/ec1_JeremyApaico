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

import com.idat.ec1.dto.UniversidadRequestDTO;
import com.idat.ec1.model.Universidad;
import com.idat.ec1.service.UniversidadService;




@RestController
@RequestMapping("/universidad/ec1")
public class UniversidadController {

	@Autowired
	private UniversidadService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<Universidad>>listar(){
		
		return new ResponseEntity<List<Universidad>>(service.listarUniversidad(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UniversidadRequestDTO universidad){
		service.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Universidad> clientsById(@PathVariable Integer id){
		Universidad uni = service.UniversidadById(id);
		if(uni != null) {
			return new ResponseEntity<Universidad>(uni, HttpStatus.OK);

		}
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad uni = service.UniversidadById(id);
		if(uni != null) {
			service.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Universidad universidad){
		Universidad uni = service.UniversidadById(universidad.getIdUniversidad());
		if(uni != null) {
			service.editarUniversidad(uni);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
