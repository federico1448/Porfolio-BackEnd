package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miaplicacion.primerproyecto.jpa.extension.ProyectRepository;
import com.miaplicacion.primerproyecto.jpa.interfaces.IProyectService;
import com.miaplicacion.primerproyecto.model.Proyect;

public class ProyectService implements IProyectService{
	@Autowired
	private ProyectRepository proyectRepository;

	@Override
	public List<Proyect> getProyect() {
		List<Proyect> listProyects= proyectRepository.findAll();
		return listProyects;
	}

	@Override
	public void saveProyect(Proyect proyect) {
		proyectRepository.save(proyect);
	}

	@Override
	public void deleteProyect(Long id) {
		proyectRepository.deleteById(id);
	}

	@Override
	public Proyect findProyect(Long id) {
		Proyect proyect= proyectRepository.findById(id).orElse(null);
		return proyect;
	}

}