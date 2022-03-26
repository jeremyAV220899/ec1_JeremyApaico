package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.dto.CursoRequestDTO;
import com.idat.ec1.model.Curso;
import com.idat.ec1.repository.CursoRepository;
@Service
public class CursoServiceImpl implements CursoService {


	@Autowired
	private CursoRepository repository;
	
	@Override
	public void guardarCurso(CursoRequestDTO p) {
		Curso curso = new Curso();
		curso.setIdCurso(p.getIdCurso());
		curso.setDescripcion(p.getDescripcion());
		curso.setCurso(p.getCurso());
		repository.save(curso);
	}
	
	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarCurso(Curso c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);
	}
	
	@Override
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Curso CursoById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
