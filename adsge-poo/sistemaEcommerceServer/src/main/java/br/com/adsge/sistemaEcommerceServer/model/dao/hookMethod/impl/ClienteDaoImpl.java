package br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod.impl;

import java.util.HashMap;
import java.util.Map;

import br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod.ClienteDao;
import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 15/04/2016
 *
 */
public class ClienteDaoImpl extends CrudDaoImpl<Cliente, Integer> implements ClienteDao {

	@Override
	protected Integer getPk(Cliente cliente) {
		return cliente.getCodigo();
	}

	@Override
	protected String getQueryPesquisar(Cliente cliente) {
		StringBuilder sql = new StringBuilder("from Cliente c where 1 = 1 ");

		if (cliente.getCodigo() != null) {
			sql.append("and c.codigo = :codigo ");
		}

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			sql.append("and c.nome = :nome");
		}

		return sql.toString();
	}

	@Override
	protected Map<String, Object> getParametros(Cliente cliente) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (cliente.getCodigo() != null) {
			map.put("codigo", cliente.getCodigo());
		}

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			map.put("nome", cliente.getNome());
		}

		return map;
	}

}
