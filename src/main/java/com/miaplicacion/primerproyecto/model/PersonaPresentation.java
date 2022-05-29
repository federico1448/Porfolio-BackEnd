package com.miaplicacion.primerproyecto.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Getter @Setter
@Entity
public class PersonaPresentation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String description;
	@ElementCollection
	private List<String> titulos;
	private byte[]imagenperfil;
	
}