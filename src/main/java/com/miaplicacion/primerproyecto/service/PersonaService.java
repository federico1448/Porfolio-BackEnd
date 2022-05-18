package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaplicacion.primerproyecto.jpa.IPersonaService;
import com.miaplicacion.primerproyecto.jpa.PersonaRepository;
import com.miaplicacion.primerproyecto.model.Persona;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private PersonaRepository persoRepository;

	@Override
	public List<Persona> getPersonas() {
		List<Persona> listaPersonas=persoRepository.findAll();
		return listaPersonas;
	}

	@Override
	public void savePersona(Persona perso) {
		persoRepository.save(perso);
		
	}

	@Override
	public void deletePersona(Long id) {
		persoRepository.deleteById(id);
		
	}

	@Override
	public Persona findPersona(Long id) {
		Persona perso= persoRepository.findById(id).orElse(null);
		return perso;
	}
}
