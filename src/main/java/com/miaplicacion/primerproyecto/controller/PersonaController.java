package com.miaplicacion.primerproyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miaplicacion.primerproyecto.jpa.IPersonaService;
import com.miaplicacion.primerproyecto.model.Persona;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService interpersona;
	
	@GetMapping("/personas/traer")
	public List<Persona> getPersonas(){
		return 	interpersona.getPersonas();
	}
	
	@PostMapping("/personas/crear")
	public String createPersona(@RequestBody Persona perso) {
		interpersona.savePersona(perso);
		return "La persona fue creada exitosamente";
	}
	
	@DeleteMapping("/personas/borrar/{id}")
	public String deletePersona(@PathVariable Long id) {
		interpersona.deletePersona(id);
		return "La persona fue borrada exitosamente";
	}
	
	@PutMapping("/personas/editar/{id}")
	public Persona editPersona(@PathVariable Long id,
								@RequestParam("nombre") String nombreUsuario,
								@RequestParam("apellido") String apellidoUsuario,
								@RequestParam("edad") Integer edadUsuario) {
		Persona perso=interpersona.findPersona(id);
		perso.setApellido(apellidoUsuario);
		perso.setName(nombreUsuario);
		perso.setEdad(edadUsuario);
		
		interpersona.savePersona(perso);
		return perso;
	}
	
}
