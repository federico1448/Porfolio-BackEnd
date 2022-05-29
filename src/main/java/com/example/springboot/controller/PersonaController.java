package com.example.springboot.controller;

import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.jpa.interfaces.IPersonaService;
import com.example.springboot.model.Persona;


@CrossOrigin(origins = "*")
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
		String msg="";
		if(!perso.getPassword().equals(perso.getConfirmpass())) {
			msg="la password no coincide - creacion de usuario cancelada";
			return msg;
		}
		Persona user=interpersona.findPersonabyName(perso.getName());
		if(user!=null) {
			msg="nombre de usuario ya existe - creacion de usuario cancelada";
			return msg;
		}
			
		msg="La persona fue creada exitosamente";
		interpersona.savePersona(perso);
		return msg;
	}
	
	
	@PostMapping("/personas/login")
	public Boolean loginPersona(@RequestParam("name") String name,
								@RequestParam("password") String password) {
		try {
			JSONObject json= new JSONObject();
			Persona user= interpersona.findPersonabyName(name);
			if(user!=null) {
				if(!user.getPassword().equals(password)) {
					json.put("result", "password incorrecto");
					return false;
				}
				json.put("result", "success");
				return true;
			}else {
				json.put("result", "usuario identificado con nombre "+name+" no existe");
				return false;
			}
		} catch (Exception e) {
			return false;
		}
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
