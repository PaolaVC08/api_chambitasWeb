package com.chambitasweb.chambitasweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.chambitasweb.chambitasweb.repository")  // Asegúrate de escanear el paquete de repositorios

public class ChambitaswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChambitaswebApplication.class, args);
	}

}
