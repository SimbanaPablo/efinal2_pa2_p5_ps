package com.uce.edu.ec.repository.modelo.dto;

import java.time.LocalDateTime;

public class MatriculaDTO {
	private String cedulaEstudiante;
	private String codigoMateria;
	private LocalDateTime fechaMatricula;

	public MatriculaDTO(String cedulaEstudiante, String nombreMateria, LocalDateTime fechaMatricula) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoMateria = nombreMateria;
		this.fechaMatricula = fechaMatricula;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getNombreMateria() {
		return codigoMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.codigoMateria = nombreMateria;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
}
