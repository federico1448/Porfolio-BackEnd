package com.example.springboot.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.model.Education;

@Service
public interface IEducationService {
	
	public List<Education> getEducation();
	
	public void saveEducation(Education education);
	
	public void deleteEducation(Long id);
	
	public Education findEducacion(Long id);
	
	public Education findEducationByName(String name);

}
