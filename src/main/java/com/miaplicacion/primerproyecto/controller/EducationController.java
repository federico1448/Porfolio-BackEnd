package com.miaplicacion.primerproyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miaplicacion.primerproyecto.jpa.IEducationService;
import com.miaplicacion.primerproyecto.model.Education;

@RestController
public class EducationController {
	
	@Autowired
	private IEducationService ieducation;
	
	@GetMapping("/education/getall")
	public List<Education> getEducation(){
		return ieducation.getEducation();
	}
	
	@PostMapping("/education/create")
	public String createEducation(@RequestBody Education education) {
		ieducation.saveEducation(education);
		return "education saved successfully";
	}
	
	@DeleteMapping("/education/delete/{id}")
	public String deleteEducation(@PathVariable Long id) {
		ieducation.deleteEducation(id);
		return "education removed sussessfully";
	}
	
	@PutMapping("/education/edit/{id}")
	public Education editEducation(@PathVariable Long id,
									@RequestParam("name") String nameEdu,
									@RequestParam("site") String siteEdu,
									@RequestParam("year") String yearEdu,
									@RequestParam("logo") String logoEdu) {
		Education education=ieducation.findEducacion(id);
		education.setName(nameEdu);
		education.setSite(siteEdu);
		education.setYear(yearEdu);
		education.setLogo(logoEdu);
		ieducation.saveEducation(education);
		return education;
	}

}
