/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEcommerceServer.model.dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemaEcommerceServer.model.dao.ClienteDao;
import br.com.sistemaEcommerceServer.model.dao.PedidoDao;
import br.com.sistemaEcommerceServer.model.domain.Cliente;
import br.com.sistemaEcommerceServer.model.domain.Pedido;
import br.com.sistemaEcommerceServer.util.Conexao;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public class PedidoDaoImpl extends UnicastRemoteObject implements PedidoDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416035164359776792L;

	public PedidoDaoImpl() throws RemoteException {
	}

	@Override
	public void salvar(Pedido cliente) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();

		if (cliente.getNumero() != null) {
			cliente = em.merge(cliente);
		}

		em.persist(cliente);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void excluir(Pedido cliente) throws RemoteException {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();

		cliente = em.merge(cliente);
		em.remove(cliente);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> pesquisar(Pedido pedido) {
		EntityManager em = Conexao.getEntityManager();

		StringBuilder sql = new StringBuilder("from Pedido p where 1 = 1 ");

		if (pedido.getNumero() != null) {
			sql.append("and p.numero = :numero ");
		}

		if (pedido.getCliente() != null) {
			sql.append("and p.cliente.codigo = :codigoCliente");
		}

		Query query = em.createQuery(sql.toString());

		if (pedido.getNumero() != null) {
			query.setParameter("numero", pedido.getNumero());
		}

		if (pedido.getCliente() != null) {
			query.setParameter("codigoCliente", pedido.getCliente().getCodigo());
		}

		return query.getResultList();

	}

	@Override
	public List<Cliente> buscarClientes() throws RemoteException {
		ClienteDao clienteDao = new ClienteDaoImpl();
		return clienteDao.pesquisar(new Cliente());
	}
}
