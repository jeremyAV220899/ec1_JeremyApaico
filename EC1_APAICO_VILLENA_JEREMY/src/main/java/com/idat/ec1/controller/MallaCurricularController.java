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

import com.idat.ec1.dto.MallaRequestDTO;
import com.idat.ec1.model.MallaCurricular;
import com.idat.ec1.service.MallaCurricularService;

@RestController
@RequestMapping("/mallacurricular/ec1")
public class MallaCurricularController {

	@Autowired
	private MallaCurricularService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<MallaCurricular>>listar(){
		
		return new ResponseEntity<List<MallaCurricular>>(service.listarMallaCurricular(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody MallaRequestDTO malla){
		service.guardarMallaCurricular(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		MallaCurricular mallaCurricular = service.MallaCurricularById(id);
		if(mallaCurricular != null) {
			service.eliminarMallaCurricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<MallaCurricular> MallaCurricularById(@PathVariable Integer id){
		MallaCurricular mallaCurricular = service.MallaCurricularById(id);
		if(mallaCurricular != null) {
			return new ResponseEntity<MallaCurricular>(mallaCurricular, HttpStatus.OK);

		}
		return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody MallaCurricular mallaCurricular){
		MallaCurricular malla = service.MallaCurricularById(mallaCurricular.getIdMalla());
		if(malla != null) {
			service.editarMallaCurricular(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
