package com.delegrego.exemplo_jpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private int idDepartamento;

	@Column(name = "nm_departamento")
	private String nmDepartamento;

	public Departamento(int idDepartamento, String nmDepartamento) {
		this.idDepartamento = idDepartamento;
		this.nmDepartamento = nmDepartamento;
	}

	public Departamento() {

	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNmDepartamento() {
		return nmDepartamento;
	}

	public void setNmDepartamento(String nmDepartamento) {
		this.nmDepartamento = nmDepartamento;
	}

	@Override
	public String toString() {
		return "\n\nDepartamento: " + idDepartamento + "\nNome: " + nmDepartamento;
	}

}
