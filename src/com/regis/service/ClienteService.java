package com.regis.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClienteService {

	public void executar() throws InterruptedException {
		System.out.println("# In�cio\n");
		
		List<String> clientes = Arrays.asList("Ana", "Am�lia", "Ariana", "B�rbara", "Carla", "Cristina", "Fabio", 
				"Gisele", "J�ssica", "Maria", "Mariana",
				"Miranda", "Mirian", "Tereza");
		
		int qtdThreads = 5;
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(qtdThreads);
		
		clientes.forEach(cliente -> {
			executor.execute(new Runnable() {
				@Override
				public void run () {
					long thread = Thread.currentThread().getId(); // Pega n�mero da thread
					mostrarClientesNoConsole(cliente);
				}
			});
		});
		
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		
		System.out.println("\n# Fim");

	}
	
	public void mostrarClientesNoConsole(String cliente) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(cliente);
	}
	
}
