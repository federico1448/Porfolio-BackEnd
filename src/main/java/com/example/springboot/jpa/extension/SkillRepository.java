package com.example.springboot.jpa.extension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Skill;



@Repository
public interface SkillRepository extends JpaRepository<Skill,Long>{
	Skill findByName(String name);
}
