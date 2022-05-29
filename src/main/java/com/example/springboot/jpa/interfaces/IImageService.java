package com.example.springboot.jpa.interfaces;

import java.util.List;

import com.example.springboot.model.Imagen;



public interface IImageService {
	
	public List<Imagen> getImagen();
	
	public void saveImagen(Imagen experience);
	
	public void deleteImagen(Long id);
	
	public Imagen findImagen(Long id);
}
