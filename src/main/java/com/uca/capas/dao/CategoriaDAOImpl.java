package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(categoria);
	}

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria>resulset =  query.getResultList();
		return resulset;
	}

}
