package com.uce.edu.ec.repository;

import com.uce.edu.ec.repository.modelo.Materia;

public interface IMateriaRepository {
	public void insertar(Materia Materia);

	public Materia seleccionar(String codigo);
}
