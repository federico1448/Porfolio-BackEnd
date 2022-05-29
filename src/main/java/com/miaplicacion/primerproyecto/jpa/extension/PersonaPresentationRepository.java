package com.miaplicacion.primerproyecto.jpa.extension;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miaplicacion.primerproyecto.model.PersonaPresentation;

@Repository
public interface PersonaPresentationRepository extends JpaRepository<PersonaPresentation,Long>{

	PersonaPresentation findByName(String name); 
}
