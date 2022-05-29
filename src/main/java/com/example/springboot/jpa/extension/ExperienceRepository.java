package com.example.springboot.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Experience;


@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
	Experience findByName(String name);
}
