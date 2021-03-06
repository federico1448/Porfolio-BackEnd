package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter @Setter
@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String apellido;
	private int edad;
	private String password;
	private String confirmpass;
	
}