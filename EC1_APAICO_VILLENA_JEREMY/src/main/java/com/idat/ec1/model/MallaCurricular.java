package com.idat.ec1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Table(name = "mallacurricular")
@Entity
public class MallaCurricular implements Serializable{

	private static final long serialVersionUID = 6026109738059984351L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private Integer anio;
	
	@OneToOne
	@JoinColumn(name="id_malla", nullable = false, unique = true, 
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references universidad (id_malla)"))
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallacurricular")
	private List<Curso> cursos = new ArrayList<>();
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
