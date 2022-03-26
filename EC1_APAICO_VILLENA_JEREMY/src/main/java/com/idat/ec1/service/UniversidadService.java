package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.dto.UniversidadRequestDTO;
import com.idat.ec1.model.Universidad;

public interface UniversidadService {

	public List<Universidad> listarUniversidad();

	public Universidad UniversidadById(Integer id);

	public void guardarUniversidad(UniversidadRequestDTO p);

	public void eliminarUniversidad(Integer id);

	public void editarUniversidad(Universidad m);

	
}
