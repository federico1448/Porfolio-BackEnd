package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.jpa.extension.ExperienceRepository;
import com.example.springboot.jpa.interfaces.IExperienceService;
import com.example.springboot.model.Experience;

@Service
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
	
	@Override
	public Experience findExperienceByName(String name) {
		Experience experience= experienceRepository.findByName(name);
		return experience;
	}

}
