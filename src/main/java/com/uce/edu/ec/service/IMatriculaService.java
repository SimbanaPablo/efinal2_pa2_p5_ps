package com.uce.edu.ec.service;

import java.util.List;

import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.ec.service.to.MatriculaTO;

public interface IMatriculaService {
	public List<MatriculaDTO> reporteMatriculas();

	public void matriculaMultiple(MatriculaTO matriculaTO);

	public void matricula(String cedula, String codigo, Matricula matricula);

}
