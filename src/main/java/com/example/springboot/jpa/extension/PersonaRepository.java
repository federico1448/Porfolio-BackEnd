package com.example.springboot.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{

	Persona findByName(String name); 
}
