package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.dto.ProfesorRequestDTO;
import com.idat.ec1.model.Profesor;

public interface ProfesorService {

	public Profesor ProfesorById(Integer id);
	public void eliminarProfesor(Integer id);
	public List<Profesor> listarProfesor();
	public void editarProfesor(Profesor m);
	public void guardarProfesor(ProfesorRequestDTO p);

}
