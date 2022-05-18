package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.miaplicacion.primerproyecto.jpa.extension.EducationRepository;
import com.miaplicacion.primerproyecto.jpa.interfaces.IEducationService;
import com.miaplicacion.primerproyecto.model.Education;

public class EducationService  implements IEducationService{
	@Autowired
	private EducationRepository educationRepository;

	@Override
	public List<Education> getEducation() {
		List<Education> listEducation= educationRepository.findAll();
		return listEducation;
	}

	@Override
	public void saveEducation(Education education) {
		educationRepository.save(education);
		
	}

	@Override
	public void deleteEducation(Long id) {
		educationRepository.deleteById(id);
		
	}

	@Override
	public Education findEducacion(Long id) {
		Education education=educationRepository.findById(id).orElse(null);
		return education;
	}

}
