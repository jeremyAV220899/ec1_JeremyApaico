package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.dto.MallaRequestDTO;
import com.idat.ec1.model.MallaCurricular;
import com.idat.ec1.repository.MallaCurricularRepository;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

	@Autowired
	private MallaCurricularRepository repository;
	
	
	@Override
	public void guardarMallaCurricular(MallaRequestDTO p) {
		MallaCurricular malla = new MallaCurricular();
		malla.setIdMalla(p.getIdMalla());
		malla.setAnio(p.getAnio());
		repository.save(malla);
	}
	
	@Override
	public void eliminarMallaCurricular(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarMallaCurricular(MallaCurricular m) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(m);
	}
	
	@Override
	public List<MallaCurricular> listarMallaCurricular() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public MallaCurricular MallaCurricularById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
