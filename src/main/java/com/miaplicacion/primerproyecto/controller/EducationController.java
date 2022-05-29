package com.miaplicacion.primerproyecto.controller;

import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.miaplicacion.primerproyecto.jpa.IEducationService;
import com.miaplicacion.primerproyecto.model.Education;


@CrossOrigin(origins = "*")
@RestController
public class EducationController {
	
	@Autowired
	private IEducationService ieducation;
	
	@GetMapping("/education/getall")
	public List<Education> getEducation(){
		return ieducation.getEducation();
	}
	
	@GetMapping("/education/get/{id}")
	public Education getOneEducation(@PathVariable Long id){
		return ieducation.findEducacion(id);
	}
	
	@PostMapping("/education/create")
	public String createEducation(@RequestBody Education education) {
		ieducation.saveEducation(education);
		return "education saved successfully";
	}
	
	@PostMapping("/education/create2")
	public Education createEducation2(@RequestParam("name") String name,
			@RequestParam("site") String site,
			@RequestParam("year") String year,
			@RequestParam("file")  MultipartFile[] request) {
		Education exp= new Education();
		exp.setName(name);
		exp.setSite(site);
		exp.setYear(year);
		try {
			exp.setLogo(request[0].getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ieducation.saveEducation(exp);
		Education exp1= ieducation.findEducationByName(name);
		return exp1;
	}
	
	
	
	@DeleteMapping("/education/delete/{id}")
	public Education deleteEducation(@PathVariable Long id) {
		Education educa=ieducation.findEducacion(id);
		ieducation.deleteEducation(id);
		return educa;
	}
	
	@PostMapping("/education/edit/{id}")
	public Education editEducation(@PathVariable Long id,
			@RequestParam("name") String nameEdu,
			@RequestParam("site") String siteEdu,
			@RequestParam("year") String yearEdu) {

			Education education=ieducation.findEducacion(id);
			education.setName(nameEdu);
			education.setSite(siteEdu);
			education.setYear(yearEdu);
			ieducation.saveEducation(education);
			return education;
	}
	
	@PostMapping("/education/editlogo/{id}")
	public Education editEducationLogo(@PathVariable Long id,
			@RequestParam("file")  MultipartFile[] request) {
		try {
			Education education=ieducation.findEducacion(id);
			education.setLogo(request[0].getBytes());
			ieducation.saveEducation(education);
			return education;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
