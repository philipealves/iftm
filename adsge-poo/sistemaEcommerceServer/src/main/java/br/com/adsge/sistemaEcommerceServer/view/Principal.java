package br.com.adsge.sistemaEcommerceServer.view;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.adsge.sistemaEcommerceServer.model.dao.impl.ClienteDaoImpl;
import br.com.adsge.sistemaEcommerceServer.model.dao.impl.PedidoDaoImpl;
import br.com.adsge.sistemaEcommerceServer.model.service.rmi.ClienteService;
import br.com.adsge.sistemaEcommerceServer.model.service.rmi.PedidoService;
import br.com.adsge.sistemaEcommerceServer.model.service.rmi.impl.ClienteServiceImpl;
import br.com.adsge.sistemaEcommerceServer.model.service.rmi.impl.PedidoServiceImpl;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Tentando subir serviço...");
		try {
			LocateRegistry.createRegistry(1099);
			Naming.bind(ClienteService.URL_SERVICO, new ClienteServiceImpl(new ClienteDaoImpl()));
			Naming.bind(PedidoService.URL_SERVICO, new PedidoServiceImpl(new PedidoDaoImpl()));
			System.out.println("Serviço iniciado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao iniciar o serviço!");
		}
	}
}
