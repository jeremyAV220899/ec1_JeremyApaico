package com.idat.ec1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Table(name = "Profesor")
@Entity
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String Profesor;
	
	@ManyToMany(mappedBy = "profesors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Curso> curso = new ArrayList<>();
	
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return Profesor;
	}
	public void setProfesor(String profesor) {
		Profesor = profesor;
	}
	
	
}
