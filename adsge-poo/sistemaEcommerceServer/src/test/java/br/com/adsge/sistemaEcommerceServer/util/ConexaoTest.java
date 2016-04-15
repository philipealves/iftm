package br.com.adsge.sistemaEcommerceServer.util;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConexaoTest {
	private EntityManager entityManager;

	@Test
	public void testConnection() {
		
		entityManager = Conexao.getEntityManager();
		
		assertNotNull(entityManager);
	}

}
