package com.uce.edu.ec.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.repository.IEstudianteRepository;
import com.uce.edu.ec.repository.IMateriaRepository;
import com.uce.edu.ec.repository.IMatriculaRepository;
import com.uce.edu.ec.repository.modelo.Estudiante;
import com.uce.edu.ec.repository.modelo.Materia;
import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.ec.service.to.MatriculaTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporteMatriculas() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionarTodo();
	}

	@Override

	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculaMultiple(MatriculaTO matriculaTO) {
		// TODO Auto-generated method stub
		Matricula m1 = new Matricula();
		m1.setFecha(LocalDate.now());
		Materia ma1 = new Materia();
		ma1.setCodigo(matriculaTO.getCodigoMateria1());
		m1.setMateria(ma1);

		Matricula m2 = new Matricula();
		m2.setFecha(LocalDate.now());
		Materia ma2 = new Materia();
		ma2.setCodigo(matriculaTO.getCodigoMateria2());
		m2.setMateria(ma2);

		Matricula m3 = new Matricula();
		m3.setFecha(LocalDate.now());
		Materia ma3 = new Materia();
		ma3.setCodigo(matriculaTO.getCodigoMateria3());
		m3.setMateria(ma3);

		Matricula m4 = new Matricula();
		Materia ma4 = new Materia();
		ma4.setCodigo(matriculaTO.getCodigoMateria4());
		m4.setMateria(ma4);

		List<Matricula> matriculas = new ArrayList<>();

		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		matriculas.add(m4);

		this.matricula(matriculaTO.getCedulaEstudiante(), matriculaTO.getCodigoMateria1(), m1);
		this.matricula(matriculaTO.getCedulaEstudiante(), matriculaTO.getCodigoMateria2(), m2);
		this.matricula(matriculaTO.getCedulaEstudiante(), matriculaTO.getCodigoMateria3(), m3);
		this.matricula(matriculaTO.getCedulaEstudiante(), matriculaTO.getCodigoMateria4(), m4);

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricula(String cedula, String codigo, Matricula matricula) {
		// TODO Auto-generated method stub

		Estudiante estudiante = this.estudianteRepository.seleccionar(cedula);
		Materia materia = this.materiaRepository.seleccionar(codigo);

		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDate.now());
		this.matriculaRepository.insertar(matricula);
	}

}
