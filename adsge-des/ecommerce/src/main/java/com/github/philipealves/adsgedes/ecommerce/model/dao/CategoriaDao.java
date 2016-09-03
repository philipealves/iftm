package com.github.philipealves.adsgedes.ecommerce.model.dao;

import java.util.List;

import com.github.philipealves.adsgedes.ecommerce.model.domain.Categoria;

public interface CategoriaDao {
	void salvar(Categoria categoria);

	void atualizar(Categoria categoria);

	void excluir(Categoria categoria);

	List<Categoria> buscar(Categoria categoria);

	List<Categoria> listar();

}
