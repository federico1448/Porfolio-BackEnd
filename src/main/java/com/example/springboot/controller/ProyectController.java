package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.jpa.interfaces.IProyectService;
import com.example.springboot.model.Proyect;

@CrossOrigin(origins = "*")
@RestController
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
	
	@PostMapping("/proyect/create2")
	public Proyect createProyect2(@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("decription") String decription,
			@RequestParam("evidence") String evidence) {
		Proyect proyect=new Proyect();
		proyect.setName(name);
		proyect.setDate(date);
		proyect.setDecription(decription);
		proyect.setEvidence(evidence);
		iproyectService.saveProyect(proyect);
		Proyect proyect1=iproyectService.findProyectByName(proyect.getName());
		return proyect1;
	}
	
	@DeleteMapping("/proyect/delete/{id}")
	public Proyect deleteProyect(@PathVariable Long id) {
		Proyect pro=iproyectService.findProyect(id);
		iproyectService.deleteProyect(id);
		return pro;
	}
	
	@PostMapping("/proyect/edit/{id}")
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



