package com.miaplicacion.primerproyecto.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.miaplicacion.primerproyecto.jpa.interfaces.IImageService;
import com.miaplicacion.primerproyecto.model.Imagen;

@CrossOrigin(origins = "*")
@RestController
public class ImageController {

	@Autowired
	private IImageService imageService;
	
	@GetMapping("/image/getall")
	public List<Imagen> getImages(){
		return imageService.getImagen();
	}
	
	@GetMapping("/image/get/{id}")
	public Imagen obtainImage(@PathVariable Long id) {
		Imagen image=imageService.findImagen(id);
		byte[] response= Base64.getEncoder().encode(image.getImage());
		return image;
	}
	
	@PostMapping("/image/create")
	public String createImage(@RequestBody Imagen image) {
		imageService.saveImagen(image);
		return "experience created successfully";
	}
	
	@DeleteMapping("/image/delete/{id}")
	public String deleteImage(@PathVariable Long id) {
		imageService.deleteImagen(id);
		return "experience deleted successfully";
	}
	
	@PutMapping("/image/edit/{id}")
	public Imagen editImage(@PathVariable Long id,
										@RequestParam("name") String name,
										@RequestParam("image") byte[] imagen,
										@RequestParam("imagetype") String imagetype,
										@RequestParam("desciption") String descriptionExp,
										@RequestParam(required=false ,name="logo") String logoExp) {
		Imagen image=imageService.findImagen(id);
		image.setName(name);
		image.setImage(imagen);
		image.setImagetype(imagetype);
		return image;
	}
	
	@PostMapping("/image/image")
	public String updateImage(@RequestParam("file")  MultipartFile[] request) {
		System.out.println("llego");
		try {		
			Imagen img= new Imagen();
			img.setImage(request[0].getBytes());
			img.setImagetype(request[0].getContentType());
			img.setName(request[0].getOriginalFilename());
			imageService.saveImagen(img);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "La imagen fue creada exitosamente";
	}
}
