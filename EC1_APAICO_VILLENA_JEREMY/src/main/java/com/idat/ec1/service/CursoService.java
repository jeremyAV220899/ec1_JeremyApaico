package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.dto.CursoRequestDTO;
import com.idat.ec1.model.Curso;

public interface CursoService {

	public void guardarCurso(CursoRequestDTO p);
	public void eliminarCurso(Integer id);
	public void editarCurso(Curso c);
	public List<Curso> listarCursos();
	public Curso CursoById(Integer id);
}
