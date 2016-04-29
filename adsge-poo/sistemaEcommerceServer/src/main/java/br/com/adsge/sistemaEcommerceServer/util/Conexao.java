package br.com.adsge.sistemaEcommerceServer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 22/03/2016
 *
 */
public class Conexao {

	private static EntityManagerFactory emf;
	private static Conexao conexao;

	private Conexao() {
		emf = Persistence.createEntityManagerFactory("SistemaEcommercePU");
	}

	public synchronized static EntityManager getEntityManager() {
		if (conexao == null) {
			conexao = new Conexao();
		}
		return emf.createEntityManager();
	}
}
