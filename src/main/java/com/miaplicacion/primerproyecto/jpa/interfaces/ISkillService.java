package com.miaplicacion.primerproyecto.jpa.interfaces;

import java.util.List;

import com.miaplicacion.primerproyecto.model.Skill;


public interface ISkillService {
	
	public List<Skill> getSkill();
	
	public void saveSkill(Skill skill);
	
	public void deleteSkill(Long id);
	
	public Skill findSkill(Long id);

}
