/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adsge.sistemaEcommerceServer.model.dao.impl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.adsge.sistemaEcommerceServer.model.dao.PedidoDao;
import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;
import br.com.adsge.sistemaEcommerceServer.util.Conexao;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public class PedidoDaoImpl implements PedidoDao {

	private EntityManager entityManager;

	public PedidoDaoImpl() throws RemoteException {
		entityManager = Conexao.getEntityManager();
	}	

	@Override
	public Pedido salvar(Pedido pedido) {
		entityManager.getTransaction().begin();

		if (pedido.getNumero() != null) {
			pedido = entityManager.merge(pedido);
		}

		entityManager.persist(pedido);

		entityManager.getTransaction().commit();

		return pedido;
	}

	@Override
	public Pedido excluir(Pedido pedido) {
		entityManager.getTransaction().begin();

		pedido = entityManager.merge(pedido);
		entityManager.remove(pedido);

		entityManager.getTransaction().commit();

		return pedido;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> pesquisar(Pedido pedido) {
		StringBuilder sql = new StringBuilder("from Pedido p where 1 = 1 ");

		if (pedido.getNumero() != null) {
			sql.append("and p.numero = :numero ");
		}

		if (pedido.getCliente() != null) {
			sql.append("and p.cliente.codigo = :codigoCliente");
		}

		Query query = entityManager.createQuery(sql.toString());

		if (pedido.getNumero() != null) {
			query.setParameter("numero", pedido.getNumero());
		}

		if (pedido.getCliente() != null) {
			query.setParameter("codigoCliente", pedido.getCliente().getCodigo());
		}

		return query.getResultList();

	}

	/*@Override
	public List<Cliente> buscarClientes() {
		ClienteDao clienteDao = null;
		try {
			clienteDao = new ClienteDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return clienteDao.pesquisar(new Cliente());
	}*/
}
