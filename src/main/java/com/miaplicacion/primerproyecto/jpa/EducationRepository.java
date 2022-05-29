package com.miaplicacion.primerproyecto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miaplicacion.primerproyecto.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long>{
	Education findByName(String name);
}
