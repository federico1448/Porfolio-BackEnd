package com.miaplicacion.primerproyecto.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miaplicacion.primerproyecto.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{

}
