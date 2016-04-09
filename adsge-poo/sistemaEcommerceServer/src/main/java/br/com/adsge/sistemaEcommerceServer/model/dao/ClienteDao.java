package br.com.adsge.sistemaEcommerceServer.model.dao;

import java.util.List;

import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public interface ClienteDao {

	Cliente excluir(Cliente cliente);

	List<Cliente> pesquisar(Cliente cliente);

	Cliente salvar(Cliente cliente);

}
