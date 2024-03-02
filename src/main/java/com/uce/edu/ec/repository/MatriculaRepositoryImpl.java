package com.uce.edu.ec.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarTodo() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> mq = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.ec.repository.modelo.dto.MatriculaDTO(m.estudiante.cedulaEstudiante,m.nombreMateria,m.fechaMatricula) FROM Matricula m",
				MatriculaDTO.class);
		return mq.getResultList();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

}
