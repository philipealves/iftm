package br.com.adsge.sistemaEcommerceServer.model.dao;

import java.rmi.Remote;
import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public interface PedidoDao extends Remote {

	Pedido excluir(Pedido pedido);

	List<Pedido> pesquisar(Pedido pedido);

	Pedido salvar(Pedido pedido);

	// List<Cliente> buscarClientes();

}
