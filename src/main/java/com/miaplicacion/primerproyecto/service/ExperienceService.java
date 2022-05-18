package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miaplicacion.primerproyecto.jpa.extension.ExperienceRepository;
import com.miaplicacion.primerproyecto.jpa.interfaces.IExperienceService;
import com.miaplicacion.primerproyecto.model.Experience;

public class ExperienceService implements IExperienceService{
	@Autowired
	private ExperienceRepository experienceRepository;

	@Override
	public List<Experience> getExperience() {
		List<Experience> experiences= experienceRepository.findAll();
		return experiences;
	}

	@Override
	public void saveExperience(Experience experience) {
		experienceRepository.save(experience);
		
	}

	@Override
	public void deleteExperience(Long id) {
		experienceRepository.deleteById(id);
		
	}

	@Override
	public Experience findExperience(Long id) {
		Experience experience= experienceRepository.findById(id).orElse(null);
		return experience;
	}

}
