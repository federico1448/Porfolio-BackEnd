package com.miaplicacion.primerproyecto.jpa.interfaces;

import java.util.List;

import com.miaplicacion.primerproyecto.model.Proyect;



public interface IProyectService {
	public List<Proyect> getProyect();
	
	public void saveProyect(Proyect proyect);
	
	public void deleteProyect(Long id);
	
	public Proyect findProyect(Long id);

}
