package com.miaplicacion.primerproyecto.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miaplicacion.primerproyecto.model.Education;

@Service
public interface IEducationService {
	
	public List<Education> getEducation();
	
	public void saveEducation(Education education);
	
	public void deleteEducation(Long id);
	
	public Education findEducacion(Long id);
	
	public Education findEducationByName(String name);

}
