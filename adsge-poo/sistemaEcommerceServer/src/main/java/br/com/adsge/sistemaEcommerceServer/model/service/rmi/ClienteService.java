package br.com.adsge.sistemaEcommerceServer.model.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;
import br.com.adsge.sistemaEcommerceServer.util.Constants;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 09/04/2016
 *
 */
public interface ClienteService extends Remote {

	public static final String URL_SERVICO = Constants.RMI_SERVER + "ServicoCliente";

	Cliente excluir(Cliente cliente) throws RemoteException;

	List<Cliente> pesquisar(Cliente cliente) throws RemoteException;

	Cliente salvar(Cliente cliente) throws RemoteException;
}
