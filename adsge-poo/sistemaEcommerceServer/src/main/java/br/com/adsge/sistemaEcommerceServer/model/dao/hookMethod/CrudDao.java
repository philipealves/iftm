package br.com.adsge.sistemaEcommerceServer.model.dao.hookMethod;

import java.util.List;

public interface CrudDao<T, PK> {
	public T salvar(T entity);

	public T excluir(T entity);

	public List<T> pesquisar(T entity);

}
