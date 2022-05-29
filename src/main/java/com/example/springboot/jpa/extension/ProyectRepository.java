package com.example.springboot.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Proyect;


@Repository
public interface ProyectRepository extends JpaRepository<Proyect,Long>{
	
	Proyect findByName(String name); 
}
