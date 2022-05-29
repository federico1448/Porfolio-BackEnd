package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaplicacion.primerproyecto.jpa.EducationRepository;
import com.miaplicacion.primerproyecto.jpa.IEducationService;
import com.miaplicacion.primerproyecto.model.Education;

@Service
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

	@Override
	public Education findEducationByName(String name) {
		Education  edu=educationRepository.findByName(name);
		return edu;
	}

}
