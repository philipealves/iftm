package br.com.adsge.sistemaEcommerceServer.model.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public interface ClienteDao extends Remote {

	static final String NOME_SERVICO = "ServicoCliente";
	static final String URL_SERVICO = "rmi://127.0.0.1/" + NOME_SERVICO;

	void excluir(Cliente cliente) throws RemoteException;

	List<Cliente> pesquisar(Cliente cliente) throws RemoteException;

	void salvar(Cliente cliente) throws RemoteException;

}
