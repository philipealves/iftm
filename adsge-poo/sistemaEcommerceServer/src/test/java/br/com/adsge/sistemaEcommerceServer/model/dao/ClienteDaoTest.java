package br.com.adsge.sistemaEcommerceServer.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.adsge.sistemaEcommerceServer.model.dao.impl.ClienteDaoImpl;
import br.com.adsge.sistemaEcommerceServer.model.domain.Cliente;
import br.com.adsge.sistemaEcommerceServer.model.domain.Pedido;
import br.com.adsge.sistemaEcommerceServer.util.exception.ValidacaoCampoException;

@RunWith(MockitoJUnitRunner.class)
public class ClienteDaoTest {

	private ClienteDao dao;

	@Before
	public void setUp() {
		dao = Mockito.mock(ClienteDaoImpl.class);
	}

	@Test
	public void crud() throws RemoteException {
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setNome("CLIENTE");
		cliente.setEmail("EMAIL");

		Mockito.when(dao.salvar(cliente))
				.thenReturn(new Cliente(cliente.getCodigo(), cliente.getNome(), cliente.getEmail()));

		Cliente resultInsert = dao.salvar(cliente);
		assertNotNull(resultInsert);

		cliente.setNome("NOVO NOME");
		cliente.setEmail("NOVO EMAIL");

		Mockito.when(dao.salvar(cliente)).thenReturn(new Cliente(1, cliente.getNome(), cliente.getEmail()));

		Cliente resultUpdate = dao.salvar(cliente);
		assertNotNull(resultUpdate);
		assertEquals(resultInsert, resultUpdate);
	}

	@Test
	public void validate() throws ValidacaoCampoException {
		Cliente cliente = new Cliente(1, "NOME", "EMAIL");

		boolean trueExpected = cliente.validar();

		assertTrue(trueExpected);
	}

	@Test
	public void validateNomeNull() {
		Throwable ex = null;
		boolean result = false;

		Cliente cliente = new Cliente(1, null, "EMAIL");

		try {
			cliente.validar();
		} catch (Exception e) {
			ex = e;
			result = true;
		}

		assertTrue(result);
		assertNotNull(ex);
		assertTrue(ex instanceof ValidacaoCampoException);
	}

	@Test
	public void validateNomeVazio() {
		Throwable ex = null;
		boolean result = false;

		Cliente cliente = new Cliente(1, "", "EMAIL");

		try {
			cliente.validar();
		} catch (Exception e) {
			ex = e;
			result = true;
		}

		assertTrue(result);
		assertNotNull(ex);
		assertTrue(ex instanceof ValidacaoCampoException);
	}

	@Test
	public void validateEmailNull() {
		Throwable ex = null;
		boolean result = false;

		Cliente cliente = new Cliente(1, "NOME", null);

		try {
			cliente.validar();
		} catch (Exception e) {
			ex = e;
			result = true;
		}

		assertTrue(result);
		assertNotNull(ex);
		assertTrue(ex instanceof ValidacaoCampoException);
	}

	@Test
	public void validateEmailVazio() {
		Throwable ex = null;
		boolean result = false;

		Cliente cliente = new Cliente(1, "NOME", "");

		try {
			cliente.validar();
		} catch (Exception e) {
			ex = e;
			result = true;
		}

		assertTrue(result);
		assertNotNull(ex);
		assertTrue(ex instanceof ValidacaoCampoException);
	}

	@Test
	public void equalsAndHashcode() {
		Cliente cliente = new Cliente(1, "NOME", "EMAIL");
		Cliente clienteEquals = new Cliente(1, "NOVO NOME", "NOVO EMAIL");
		Cliente clienteNotEquals = new Cliente(2, "NOME", "EMAIL");
		Cliente clienteNull = null;
		Pedido pedido = new Pedido();

		assertEquals(cliente, clienteEquals);
		assertNotEquals(cliente, clienteNotEquals);
		assertNotEquals(cliente, clienteNull);
		assertFalse(cliente.equals(pedido));

		assertEquals(cliente.hashCode(), clienteEquals.hashCode());
		assertNotEquals(cliente.hashCode(), clienteNotEquals.hashCode());
	}

}
