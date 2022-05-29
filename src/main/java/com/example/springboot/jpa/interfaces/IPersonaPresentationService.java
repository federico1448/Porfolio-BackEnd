package com.example.springboot.jpa.interfaces;

import java.util.List;

import com.example.springboot.model.PersonaPresentation;




public interface IPersonaPresentationService {
	
	public List<PersonaPresentation> getPersonas();
	
	public void savePersona (PersonaPresentation perso);
	
	public void deletePersona(Long id);
	
	public PersonaPresentation findPersona(Long id);
	
	public PersonaPresentation findPersonabyName(String name);

}
