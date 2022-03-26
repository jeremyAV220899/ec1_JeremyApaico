package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.dto.MallaRequestDTO;
import com.idat.ec1.model.MallaCurricular;

public interface MallaCurricularService {

	public void eliminarMallaCurricular(Integer id);

	public void editarMallaCurricular(MallaCurricular m);

	public List<MallaCurricular> listarMallaCurricular();

	public MallaCurricular MallaCurricularById(Integer id);

	public void guardarMallaCurricular(MallaRequestDTO p);

}
