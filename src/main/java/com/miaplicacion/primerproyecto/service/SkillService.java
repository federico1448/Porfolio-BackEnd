package com.miaplicacion.primerproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miaplicacion.primerproyecto.jpa.extension.SkillRepository;
import com.miaplicacion.primerproyecto.jpa.interfaces.ISkillService;
import com.miaplicacion.primerproyecto.model.Skill;

public class SkillService implements ISkillService{
	@Autowired
	private SkillRepository skillRepository;
	
	@Override
	public List<Skill> getSkill() {
		List<Skill> listSkills=skillRepository.findAll();
		return listSkills;
	}

	@Override
	public void saveSkill(Skill skill) {
		skillRepository.save(skill);
	}

	@Override
	public void deleteSkill(Long id) {
		skillRepository.deleteById(id);
	}

	@Override
	public Skill findSkill(Long id) {
		Skill skill=skillRepository.findById(id).orElse(null);
		return skill;
	}
	

}
