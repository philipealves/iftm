package br.com.adsge.sistemaEcommerceServer.model.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;
import br.com.adsge.sistemaEcommerceServer.util.Constants;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 09/04/2016
 *
 */
public interface PedidoService extends Remote {

	public static final String URL_SERVICO = Constants.RMI_SERVER + "ServicoPedido";

	Pedido excluir(Pedido pedido) throws RemoteException;

	List<Pedido> pesquisar(Pedido pedido) throws RemoteException;

	Pedido salvar(Pedido pedido) throws RemoteException;

	// List<Cliente> buscarClientes() throws RemoteException;
}
