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

import com.miaplicacion.primerproyecto.jpa.interfaces.IExperienceService;
import com.miaplicacion.primerproyecto.model.Experience;

@RequestMapping
public class ExperienceController {

	@Autowired
	private IExperienceService iexperienceService;
	
	@GetMapping("/experience/getall")
	public List<Experience> getExperiences(){
		return iexperienceService.getExperience();
	}
	
	@PostMapping("/experience/create")
	public String createExperience(@RequestBody Experience experience) {
		iexperienceService.saveExperience(experience);
		return "experience created successfully";
	}
	
	@DeleteMapping("/experience/delete/{id}")
	public String deleteExperience(@PathVariable Long id) {
		iexperienceService.deleteExperience(id);
		return "experience deleted successfully";
	}
	
	@PutMapping("/experience/edit/{id}")
	public Experience editExperience(@PathVariable Long id,
										@RequestParam("name") String nameExp,
										@RequestParam("period") String periodExp,
										@RequestParam("puesto") String puestExp,
										@RequestParam("desciption") String descriptionExp,
										@RequestParam("logo") String logoExp) {
		Experience experience=iexperienceService.findExperience(id);
		experience.setName(nameExp);
		experience.setDesciption(descriptionExp);
		experience.setPeriod(periodExp);
		experience.setPuesto(puestExp);
		experience.setLogo(logoExp);
		iexperienceService.saveExperience(experience);
		return experience;
	}
}
