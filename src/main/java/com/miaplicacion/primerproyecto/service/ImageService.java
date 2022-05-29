package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaplicacion.primerproyecto.jpa.extension.ImageRepository;
import com.miaplicacion.primerproyecto.jpa.interfaces.IImageService;
import com.miaplicacion.primerproyecto.model.Imagen;

@Service
public class ImageService implements IImageService{
	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public List<Imagen> getImagen() {
		List<Imagen> experiences= imageRepository.findAll();
		return experiences;
	}

	@Override
	public void saveImagen(Imagen image) {
		imageRepository.save(image);
		
	}

	@Override
	public void deleteImagen(Long id) {
		imageRepository.deleteById(id);
		
	}

	@Override
	public Imagen findImagen(Long id) {
		Imagen experience= imageRepository.findById(id).orElse(null);
		return experience;
	}

}
