package com.miaplicacion.primerproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ComponentScan({"com.miaplicacion.primerproyecto"})
@EntityScan("com.miaplicacion.primerproyecto")
@EnableJpaRepositories("com.miaplicacion.primerproyecto")
public class PrimerProyectoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PrimerProyectoApplication.class, args);
    }
    
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> setConfiguration() {
		return factory -> {
			factory.setPort(8099);
		};
    }
}
