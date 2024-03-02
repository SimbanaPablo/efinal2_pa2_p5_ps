package com.uce.edu.ec.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class IMateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia Materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(Materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionar(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> mq = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:codigo",
				Materia.class);
		mq.setParameter("codigo", codigo);
		return mq.getSingleResult();
	}

}
