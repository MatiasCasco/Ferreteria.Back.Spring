package com.casa.san.roque.ferreteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FerreteriaApplication {

	public static void main(String[] args) {
                System.setProperty("server.servlet.context-path", "/casa.san.roque");
		SpringApplication.run(FerreteriaApplication.class, args);
	}

}
