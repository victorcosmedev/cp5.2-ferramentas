package com.br.cp5.mvc_ferramentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcFerramentasApplication {

	public static void main(String[] args) {
		// =================================================================
		// ||               PASSO DE DEBUG - INÍCIO                       ||
		// =================================================================
		// Este código vai rodar ANTES do Spring Boot tentar se conectar ao banco.
		// Ele vai imprimir o valor da variável de ambiente diretamente no log.
		System.out.println("============================================================");
		System.out.println("VERIFICANDO VARIÁVEIS DE AMBIENTE NO RENDER...");
		System.out.println("Valor de SPRING_DATASOURCE_URL: [" + System.getenv("SPRING_DATASOURCE_URL") + "]");
		System.out.println("============================================================");
		// =================================================================
		// ||               PASSO DE DEBUG - FIM                          ||
		// =================================================================

		SpringApplication.run(MvcFerramentasApplication.class, args);
	}
}
