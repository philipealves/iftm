package br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod.CrudDao;
import br.com.adsge.sistemaEcommerceServer.util.Conexao;

public abstract class CrudDaoImpl<T, PK> implements CrudDao<T, PK> {

	private EntityManager entityManager;

	protected abstract PK getPk(T entity);

	protected abstract String getQueryPesquisar(T entity);

	protected abstract Map<String, Object> getParametros(T entity);

	public CrudDaoImpl() {
		entityManager = Conexao.getEntityManager();
	}

	@Override
	public T salvar(T entity) {
		entityManager.getTransaction().begin();

		if (getPk(entity) != null) {
			entity = entityManager.merge(entity);
		}

		entityManager.persist(entity);

		entityManager.getTransaction().commit();

		return entity;
	}

	@Override
	public T excluir(T entity) {
		entityManager.getTransaction().begin();

		entity = entityManager.merge(entity);
		entityManager.remove(entity);

		entityManager.getTransaction().commit();

		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> pesquisar(T entity) {
		String queryPesquisar = getQueryPesquisar(entity);

		Query query = entityManager.createQuery(queryPesquisar);
		Map<String, Object> parametros = getParametros(entity);

		for (String chave : parametros.keySet()) {
			Object valor = parametros.get(chave);
			query.setParameter(chave, valor);
		}

		return query.getResultList();
	}
}
