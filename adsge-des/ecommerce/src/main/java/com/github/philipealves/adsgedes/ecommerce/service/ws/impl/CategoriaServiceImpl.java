package com.github.philipealves.adsgedes.ecommerce.service.ws.impl;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.github.philipealves.adsgedes.ecommerce.model.dao.CategoriaDao;
import com.github.philipealves.adsgedes.ecommerce.model.domain.Categoria;
import com.github.philipealves.adsgedes.ecommerce.service.ws.CategoriaService;

@WebService(serviceName = "ws/categoria")
public class CategoriaServiceImpl implements CategoriaService {

	@Inject
	private CategoriaDao categoriaDao;

	@Override
	@WebMethod(operationName = "salvar")
	public void salvar(@WebParam(name = "categoria") Categoria categoria) {
		this.categoriaDao.salvar(categoria);
	}

	@Override
	@WebMethod(operationName = "atualizar")
	public void atualizar(@WebParam(name = "categoria") Categoria categoria) {
		this.categoriaDao.atualizar(categoria);
	}

	@Override
	@WebMethod(operationName = "excluir")
	public void excluir(@WebParam(name = "categoria") Categoria categoria) {
		this.categoriaDao.excluir(categoria);
	}

	@Override
	@WebMethod(operationName = "buscar")
	public List<Categoria> buscar(@WebParam(name = "categoria") Categoria categoria) {
		return this.categoriaDao.buscar(categoria);
	}

	@Override
	@WebMethod(operationName = "listar")
	public List<Categoria> listar() {
		return this.categoriaDao.listar();
	}

}
