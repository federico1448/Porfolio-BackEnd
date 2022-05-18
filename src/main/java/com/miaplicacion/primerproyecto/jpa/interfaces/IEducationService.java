package com.miaplicacion.primerproyecto.jpa.interfaces;

import java.util.List;

import com.miaplicacion.primerproyecto.model.Education;

public interface IEducationService {
	
	public List<Education> getEducation();
	
	public void saveEducation(Education education);
	
	public void deleteEducation(Long id);
	
	public Education findEducacion(Long id);
	

}
