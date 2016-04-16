package br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod.impl;

import java.util.HashMap;
import java.util.Map;

import br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod.PedidoDao;
import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;

public class PedidoDaoImpl extends CrudDaoImpl<Pedido, Integer> implements PedidoDao {

	@Override
	protected Integer getPk(Pedido pedido) {
		return pedido.getNumero();
	}

	@Override
	protected String getQueryPesquisar(Pedido pedido) {
		StringBuilder sql = new StringBuilder("from Pedido p where 1 = 1 ");

		if (pedido.getNumero() != null) {
			sql.append("and p.numero = :numero ");
		}

		if (pedido.getCliente() != null) {
			sql.append("and p.cliente = :cliente");
		}

		return sql.toString();
	}

	@Override
	protected Map<String, Object> getParametros(Pedido pedido) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (pedido.getNumero() != null) {
			map.put("numero", pedido.getNumero());
		}

		if (pedido.getCliente() != null) {
			map.put("cliente", pedido.getCliente());
		}

		return map;
	}

}
