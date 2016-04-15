package br.com.adsge.sistemaEcommerceServer.model.dao;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.adsge.sistemaEcommerceServer.model.dao.impl.PedidoDaoImpl;
import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;
import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;

@RunWith(MockitoJUnitRunner.class)
public class PedidoDaoTest {

	private PedidoDao dao;

	@Before
	public void setUp() {
		dao = Mockito.mock(PedidoDaoImpl.class);
	}

	@Test
	public void crud() throws RemoteException {
		Pedido pedido = new Pedido(new Cliente(1, "NOME", "EMAIL"), new Date());

		Mockito.when(dao.salvar(pedido)).thenReturn(new Pedido(1, pedido.getCliente(), pedido.getDataHora()));

		Pedido resultInsert = dao.salvar(pedido);
		Assert.assertNotNull(resultInsert);

		pedido.setDataHora(pedido.getDataHora());

		Mockito.when(dao.salvar(pedido)).thenReturn(new Pedido(1, pedido.getCliente(), pedido.getDataHora()));

		Pedido resultUpdate = dao.salvar(pedido);
		Assert.assertNotNull(resultUpdate);
		Assert.assertEquals(resultInsert, resultUpdate);
	}

}
