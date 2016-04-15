package br.com.adsge.sistemaEcommerceServer.model.service.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.dao.ClienteDao;
import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;
import br.com.adsge.sistemaEcommerceServer.model.service.rmi.ClienteService;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 09/04/2016
 *
 */
public class ClienteServiceImpl extends UnicastRemoteObject implements ClienteService {

	private static final long serialVersionUID = -5682113468659421666L;

	private ClienteDao clienteDao;

	public ClienteServiceImpl(ClienteDao clienteDao) throws RemoteException {
		this.clienteDao = clienteDao;
	}

	@Override
	public Cliente excluir(Cliente cliente) throws RemoteException {
		return clienteDao.excluir(cliente);
	}

	@Override
	public List<Cliente> pesquisar(Cliente cliente) throws RemoteException {
		return clienteDao.pesquisar(cliente);
	}

	@Override
	public Cliente salvar(Cliente cliente) throws RemoteException {
		return clienteDao.salvar(cliente);
	}

}
