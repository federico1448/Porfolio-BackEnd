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
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.jpa.interfaces.IExperienceService;
import com.example.springboot.model.Education;
import com.example.springboot.model.Experience;

@CrossOrigin(origins = "*")
@RestController
public class ExperienceController {

	@Autowired
	private IExperienceService iexperienceService;
	
	@GetMapping("/experience/getall")
	public List<Experience> getExperiences(){
		return iexperienceService.getExperience();
	}
	
	@GetMapping("/experience/get/{id}")
	public Experience getExperience(@PathVariable Long id){
		return iexperienceService.findExperience(id);
	}
	
	@PostMapping("/experience/create")
	public Experience createExperience(@RequestBody Experience experience) {
		iexperienceService.saveExperience(experience);
		experience.getName();
		Experience exp= iexperienceService.findExperienceByName(experience.getName());
		return exp;
	}
	
	@PostMapping("/experience/create2")
	public Experience createExperience2(@RequestParam("name") String nameExp,
			@RequestParam("period") String periodExp,
			@RequestParam("puesto") String puestExp,
			@RequestParam("desciption") String descriptionExp,
			@RequestParam("file")  MultipartFile[] request) {
		Experience exp= new Experience();
		exp.setName(nameExp);
		exp.setPeriod(periodExp);
		exp.setPuesto(puestExp);
		exp.setDesciption(descriptionExp);
		try {
			exp.setLogo(request[0].getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		iexperienceService.saveExperience(exp);
		Experience exp1= iexperienceService.findExperienceByName(nameExp);
		return exp1;
	}
	
	
	@DeleteMapping("/experience/delete/{id}")
	public Experience deleteExperience(@PathVariable Long id) {
		Experience exp=iexperienceService.findExperience(id);
		iexperienceService.deleteExperience(id);
		return exp;
	}
	
	@PostMapping("/experience/edit/{id}")
	public Experience editExperience(@PathVariable Long id,
										@RequestParam("name") String nameExp,
										@RequestParam("period") String periodExp,
										@RequestParam("puesto") String puestExp,
										@RequestParam("desciption") String descriptionExp) {
		Experience experience=iexperienceService.findExperience(id);
		experience.setName(nameExp);
		experience.setDesciption(descriptionExp);
		experience.setPeriod(periodExp);
		experience.setPuesto(puestExp);
		iexperienceService.saveExperience(experience);
		return experience;
	}
	
	@PostMapping("/experience/editlog/{id}")
	public Experience editExperienceLogo(@PathVariable Long id,
							@RequestParam("file")  MultipartFile[] request) {
		try {
			Experience education=iexperienceService.findExperience(id);
			education.setLogo(request[0].getBytes());
			iexperienceService.saveExperience(education);
			return education;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
