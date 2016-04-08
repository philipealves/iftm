package br.com.sistemaEcommerceServer.view;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.sistemaEcommerceServer.model.dao.ClienteDao;
import br.com.sistemaEcommerceServer.model.dao.PedidoDao;
import br.com.sistemaEcommerceServer.model.dao.impl.ClienteDaoImpl;
import br.com.sistemaEcommerceServer.model.dao.impl.PedidoDaoImpl;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Tentando subir serviço...");
		try {
			LocateRegistry.createRegistry(1099);
			Naming.bind(ClienteDao.NOME_SERVICO, new ClienteDaoImpl());
			Naming.bind(PedidoDao.NOME_SERVICO, new PedidoDaoImpl());
			System.out.println("Serviço iniciado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao iniciar o serviço!");
		}
	}
}
