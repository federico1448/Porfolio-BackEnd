package com.example.springboot.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Imagen;


@Repository
public interface ImageRepository extends JpaRepository<Imagen, Long>{

}
