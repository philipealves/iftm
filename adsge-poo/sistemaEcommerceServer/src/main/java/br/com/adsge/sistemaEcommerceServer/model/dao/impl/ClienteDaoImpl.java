/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adsge.sistemaEcommerceServer.model.dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class ClienteDaoImpl extends UnicastRemoteObject implements ClienteDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416035164359776792L;

	public ClienteDaoImpl() throws RemoteException {
	}

	@Override
	public void salvar(Cliente cliente) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();

		if (cliente.getCodigo() != null) {
			cliente = em.merge(cliente);
		}

		em.persist(cliente);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void excluir(Cliente cliente) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();

		cliente = em.merge(cliente);
		em.remove(cliente);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> pesquisar(Cliente cliente) {
		EntityManager em = Conexao.getEntityManager();

		StringBuilder sql = new StringBuilder("from Cliente c where 1 = 1 ");

		if (cliente.getCodigo() != null) {
			sql.append("and c.codigo = :codigo ");
		}

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			sql.append("and c.nome = :nome");
		}

		Query query = em.createQuery(sql.toString());

		if (cliente.getCodigo() != null) {
			query.setParameter("codigo", cliente.getCodigo());
		}

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			query.setParameter("nome", "%" + cliente.getNome());
		}
		
		return query.getResultList();

	}
}
