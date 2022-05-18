package com.miaplicacion.primerproyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miaplicacion.primerproyecto.jpa.interfaces.IProyectService;
import com.miaplicacion.primerproyecto.model.Proyect;

@RequestMapping
public class ProyectController {
	@Autowired
	private IProyectService iproyectService;

	@GetMapping("/proyect/getall")
	public List<Proyect> getProyects(){
		return iproyectService.getProyect();
	}
	
	@PostMapping("/proyect/create")
	public String createProyect(@RequestBody Proyect proyect) {
		iproyectService.saveProyect(proyect);
		return "proyect created successfully";
	}
	
	@DeleteMapping("/proyect/delete/{id}")
	public String deleteProyect(@PathVariable Long id) {
		iproyectService.deleteProyect(id);
		return "proyect deleted successfully";
	}
	
	@PutMapping("/proyect/edit/{id}")
	public Proyect editProyect(@PathVariable Long id,
								@RequestParam("name") String namePro,
								@RequestParam("date") String datePro,
								@RequestParam("decription") String descriptionPro,
								@RequestParam("evidence") String evidencePro) {
		Proyect proyect=iproyectService.findProyect(id);
		proyect.setName(namePro);
		proyect.setDate(datePro);
		proyect.setDecription(descriptionPro);
		proyect.setEvidence(evidencePro);
		iproyectService.saveProyect(proyect);
		return proyect;
		
	}
}



