package com.miaplicacion.primerproyecto.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miaplicacion.primerproyecto.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long>{
	Skill findByName(String name);
}
