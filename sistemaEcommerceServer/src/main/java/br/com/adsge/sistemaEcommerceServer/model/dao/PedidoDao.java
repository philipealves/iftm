package br.com.adsge.sistemaEcommerceServer.model.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;
import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public interface PedidoDao extends Remote {

	static final String NOME_SERVICO = "ServicoPedido";
	static final String URL_SERVICO = "rmi://127.0.0.1/" + NOME_SERVICO;

	void excluir(Pedido pedido) throws RemoteException;

	List<Pedido> pesquisar(Pedido pedido) throws RemoteException;

	void salvar(Pedido pedido) throws RemoteException;

	List<Cliente> buscarClientes() throws RemoteException;

}
