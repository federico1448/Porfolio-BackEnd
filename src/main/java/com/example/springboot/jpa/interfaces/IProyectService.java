package com.example.springboot.jpa.interfaces;

import java.util.List;

import com.example.springboot.model.Proyect;




public interface IProyectService {
	public List<Proyect> getProyect();
	
	public void saveProyect(Proyect proyect);
	
	public void deleteProyect(Long id);
	
	public Proyect findProyect(Long id);
	
	public Proyect findProyectByName(String name);

}
