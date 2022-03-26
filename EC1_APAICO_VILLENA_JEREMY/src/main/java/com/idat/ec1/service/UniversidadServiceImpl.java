package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.dto.UniversidadRequestDTO;
import com.idat.ec1.model.Universidad;
import com.idat.ec1.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private UniversidadRepository repository;
	
	@Override
	public void guardarUniversidad(UniversidadRequestDTO p) {
		Universidad uni = new Universidad();
		uni.setIdUniversidad(p.getIdUniversidad());
		uni.setUniversidad(p.getUniversidad());
		repository.save(uni);
	}
	
	@Override
	public void eliminarUniversidad(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarUniversidad(Universidad m) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(m);
	}
	
	@Override
	public List<Universidad> listarUniversidad() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Universidad UniversidadById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
