/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adsge.sistemaEcommerceServer.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.adsge.sistemaEcommerceServer.model.dao.ClienteDao;
import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;
import br.com.adsge.sistemaEcommerceServer.util.Conexao;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public class ClienteDaoImpl implements ClienteDao {

	@Override
	public Cliente salvar(Cliente cliente) {
		EntityManager entityManager = Conexao.getEntityManager();
		entityManager.getTransaction().begin();

		if (cliente.getCodigo() != null) {
			cliente = entityManager.merge(cliente);
		}

		entityManager.persist(cliente);

		entityManager.getTransaction().commit();
		entityManager.close();

		return cliente;
	}

	@Override
	public Cliente excluir(Cliente cliente) {
		EntityManager entityManager = Conexao.getEntityManager();
		entityManager.getTransaction().begin();

		cliente = entityManager.merge(cliente);
		entityManager.remove(cliente);

		entityManager.getTransaction().commit();
		entityManager.close();

		return cliente;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> pesquisar(Cliente cliente) {
		EntityManager entityManager = Conexao.getEntityManager();
		entityManager.getTransaction().begin();
		StringBuilder sql = new StringBuilder("from Cliente c where 1 = 1 ");

		if (cliente.getCodigo() != null) {
			sql.append("and c.codigo = :codigo ");
		}

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			sql.append("and c.nome = :nome");
		}

		Query query = entityManager.createQuery(sql.toString());

		if (cliente.getCodigo() != null) {
			query.setParameter("codigo", cliente.getCodigo());
		}

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			query.setParameter("nome", "%" + cliente.getNome());
		}

		return query.getResultList();

	}
}
