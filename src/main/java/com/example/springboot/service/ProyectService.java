package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.jpa.extension.ProyectRepository;
import com.example.springboot.jpa.interfaces.IProyectService;
import com.example.springboot.model.Proyect;

@Service
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

	@Override
	public Proyect findProyectByName(String name) {
		Proyect proyect= proyectRepository.findByName(name);
		return proyect;
	}

}
