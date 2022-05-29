package com.example.springboot.jpa.interfaces;

import java.util.List;

import com.example.springboot.model.Experience;



public interface IExperienceService {
	
	public List<Experience> getExperience();
	
	public void saveExperience(Experience experience);
	
	public void deleteExperience(Long id);
	
	public Experience findExperience(Long id);
	
	public Experience findExperienceByName(String name);
}
