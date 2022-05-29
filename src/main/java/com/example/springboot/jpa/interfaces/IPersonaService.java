package com.example.springboot.jpa.interfaces;

import java.util.List;

import com.example.springboot.model.Persona;



public interface IPersonaService {
	
	public List<Persona> getPersonas();
	
	public void savePersona (Persona perso);
	
	public void deletePersona(Long id);
	
	public Persona findPersona(Long id);
	
	public Persona findPersonabyName(String name);

}
