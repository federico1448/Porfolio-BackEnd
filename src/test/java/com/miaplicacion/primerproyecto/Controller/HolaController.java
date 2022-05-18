package com.miaplicacion.primerproyecto.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

	@GetMapping("/hola")
	public String decirHola() {
		return "Hello World";
	}
}
