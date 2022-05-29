package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaplicacion.primerproyecto.jpa.extension.PersonaPresentationRepository;
import com.miaplicacion.primerproyecto.jpa.interfaces.IPersonaPresentationService;
import com.miaplicacion.primerproyecto.model.PersonaPresentation;


@Service
public class PersonaPresentationService implements IPersonaPresentationService{
	
	@Autowired
	private PersonaPresentationRepository persoRepository;

	@Override
	public List<PersonaPresentation> getPersonas() {
		List<PersonaPresentation> listaPersonas=persoRepository.findAll();
		return listaPersonas;
	}

	@Override
	public void savePersona(PersonaPresentation perso) {
		persoRepository.save(perso);
	}

	@Override
	public void deletePersona(Long id) {
		persoRepository.deleteById(id);
		
	}

	@Override
	public PersonaPresentation findPersona(Long id) {
		PersonaPresentation perso= persoRepository.findById(id).orElse(null);
		return perso;
	}

	@Override
	public PersonaPresentation findPersonabyName(String name) {
		PersonaPresentation perso= persoRepository.findByName(name);
		return perso;
	}
	
	
}
