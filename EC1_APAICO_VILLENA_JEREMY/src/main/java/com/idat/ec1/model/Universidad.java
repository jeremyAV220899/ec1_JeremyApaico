package com.idat.ec1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Table(name = "universidad")
@Entity
public class Universidad {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	private String Universidad;
	
	@OneToOne(mappedBy = "universidad")
	private MallaCurricular curricular;
	
	public Integer getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return Universidad;
	}
	public void setUniversidad(String universidad) {
		Universidad = universidad;
	}
	
	
}
