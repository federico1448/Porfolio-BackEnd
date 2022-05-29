package com.example.springboot.controller;

import java.io.FileInputStream;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.jpa.interfaces.IPersonaPresentationService;
import com.example.springboot.model.PersonaPresentation;



@CrossOrigin(origins = "*")
@RestController
public class PersonaPresentationController {

	@Autowired
	private IPersonaPresentationService interpersona;
	
	
	@PostMapping("/ppresentation/image")
	public String updatePImage(@RequestParam("file")  MultipartFile[] request,
								@RequestParam("name") String name) {
		//MultipartFile multipartFile = request.getFile("file");
		System.out.println("llego");
		System.out.println(name);
		try {
			for(int i=0;i<request.length;i++) {
				System.out.println("empeza "+i);
				System.out.println(request[i].getBytes().length);
				byte[] img= Base64.getEncoder().encode(request[i].getBytes());
				//System.out.println(new String(img));
				System.out.println(request[i].getContentType());
				System.out.println(request[i].getOriginalFilename());
				System.out.println(request[i].getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "La persona fue creada exitosamente";
	}
	
	@GetMapping("/ppresentation/traer")
	public List<PersonaPresentation> getPPersonas(){
		return 	interpersona.getPersonas();
	}
	
	@GetMapping("/ppresentation/getfirt")
	public PersonaPresentation getPPersona(){
		return 	interpersona.getPersonas().get(0);
	}
	
	@PostMapping("/ppresentation/crear")
	public String createPPersona(@RequestBody PersonaPresentation perso) {
		System.out.println("llego");
		String msg="";
		msg="La presentacion fue creada exitosamente";
		
		interpersona.savePersona(perso);
		return msg;
	}
	
	
	@DeleteMapping("/ppresentation/borrar/{id}")
	public String deletePPersona(@PathVariable Long id) {
		interpersona.deletePersona(id);
		return "La persona fue borrada exitosamente";
	}
	
	@PostMapping("/ppresentation/editar/{id}")
	public PersonaPresentation editPPersona(@PathVariable Long id,
			@RequestBody PersonaPresentation perso1) {
		PersonaPresentation perso=interpersona.findPersona(id);
		perso.setName(perso1.getName());
		perso.setDescription(perso1.getDescription());
		perso.setTitulos(perso1.getTitulos());
		interpersona.savePersona(perso);
		return perso;
	}
	
	@PostMapping("/ppresentation/editlogo/{id}")
	public PersonaPresentation editPPersonaLogo(@PathVariable Long id,
			@RequestParam("file")  MultipartFile[] request) {
		try {
			PersonaPresentation perso=interpersona.findPersona(id);
			perso.setImagenperfil(request[0].getBytes());
			interpersona.savePersona(perso);
			return perso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
