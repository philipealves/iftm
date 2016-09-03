package com.github.philipealves.adsgedes.ecommerce.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.github.philipealves.adsgedes.ecommerce.model.dao.CategoriaDao;
import com.github.philipealves.adsgedes.ecommerce.model.domain.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	@PersistenceContext(name = "EcommercePU")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void salvar(Categoria categoria) {
		this.entityManager.persist(categoria);
	}

	@Override
	@Transactional
	public void atualizar(Categoria categoria) {
		Categoria merge = this.entityManager.merge(categoria);
		this.entityManager.persist(merge);
	}

	@Override
	@Transactional
	public void excluir(Categoria categoria) {
		this.entityManager.remove(categoria);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> buscar(Categoria categoria) {
		StringBuffer hql = new StringBuffer("from Categoria c where 1 = 1");

		if (categoria.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}

		if (categoria.getNome() != null) {
			hql.append(" and c.nome = :nome");
		}

		Query query = this.entityManager.createQuery(hql.toString());

		if (categoria.getCodigo() != null) {
			query.setParameter("codigo", categoria.getCodigo());
		}

		if (categoria.getNome() != null) {
			query.setParameter("nome", categoria.getNome());
		}

		return query.getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {
		Query query = this.entityManager.createQuery("from Categoria");
		return query.getResultList();
	}

}
