package com.example.springboot.jpa.extension;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.PersonaPresentation;



@Repository
public interface PersonaPresentationRepository extends JpaRepository<PersonaPresentation,Long>{

	PersonaPresentation findByName(String name); 
}
