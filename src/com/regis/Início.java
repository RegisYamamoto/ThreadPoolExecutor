package com.regis;

import com.regis.service.ClienteService;

public class Início {

	public static void main(String[] args) throws InterruptedException {
		
		ClienteService clienteService = new ClienteService();
		clienteService.executar();

	}

}
