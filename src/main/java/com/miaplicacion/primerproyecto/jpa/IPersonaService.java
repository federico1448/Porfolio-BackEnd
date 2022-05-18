package com.miaplicacion.primerproyecto.jpa;

import java.util.List;

import com.miaplicacion.primerproyecto.model.Persona;

public interface IPersonaService {
	
	public List<Persona> getPersonas();
	
	public void savePersona (Persona perso);
	
	public void deletePersona(Long id);
	
	public Persona findPersona(Long id);

}
