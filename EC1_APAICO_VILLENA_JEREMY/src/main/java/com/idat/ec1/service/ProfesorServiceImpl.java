package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.dto.ProfesorRequestDTO;
import com.idat.ec1.model.Profesor;
import com.idat.ec1.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public void guardarProfesor(ProfesorRequestDTO p) {
		Profesor pro = new Profesor();
		pro.setIdProfesor(p.getIdProfesor());
		pro.setProfesor(p.getProfesor());
		repository.save(pro);
	}
	
	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarProfesor(Profesor m) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(m);
	}
	
	@Override
	public List<Profesor> listarProfesor() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Profesor ProfesorById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
