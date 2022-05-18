package com.miaplicacion.primerproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PrimerProyectoApplication 
{

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
