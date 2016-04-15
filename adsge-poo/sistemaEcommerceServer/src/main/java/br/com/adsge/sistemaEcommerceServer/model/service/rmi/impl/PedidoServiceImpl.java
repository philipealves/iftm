package br.com.adsge.sistemaEcommerceServer.model.service.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.dao.PedidoDao;
import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;
import br.com.adsge.sistemaEcommerceServer.model.service.rmi.PedidoService;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 08/04/2016
 *
 */
public class PedidoServiceImpl extends UnicastRemoteObject implements PedidoService {

	private static final long serialVersionUID = 4552207894186989933L;

	private PedidoDao pedidoDao;

	public PedidoServiceImpl(PedidoDao pedidoDao) throws RemoteException {
		this.pedidoDao = pedidoDao;
	}

	@Override
	public Pedido excluir(Pedido pedido) throws RemoteException {
		return this.pedidoDao.excluir(pedido);
	}

	@Override
	public List<Pedido> pesquisar(Pedido pedido) throws RemoteException {
		return this.pedidoDao.pesquisar(pedido);
	}

	@Override
	public Pedido salvar(Pedido pedido) throws RemoteException {
		return this.pedidoDao.salvar(pedido);
	}

	/*
	 * @Override public List<Cliente> buscarClientes() throws RemoteException {
	 * return this.pedidoDao.buscarClientes(); }
	 */

}
