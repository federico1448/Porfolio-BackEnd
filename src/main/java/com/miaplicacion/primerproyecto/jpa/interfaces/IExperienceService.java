package com.miaplicacion.primerproyecto.jpa.interfaces;

import java.util.List;

import com.miaplicacion.primerproyecto.model.Experience;


public interface IExperienceService {
	
	public List<Experience> getExperience();
	
	public void saveExperience(Experience experience);
	
	public void deleteExperience(Long id);
	
	public Experience findExperience(Long id);
}
