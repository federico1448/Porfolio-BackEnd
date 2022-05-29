package com.example.springboot.jpa.interfaces;

import java.util.List;

import com.example.springboot.model.Skill;




public interface ISkillService {
	
	public List<Skill> getSkill();
	
	public void saveSkill(Skill skill);
	
	public void deleteSkill(Long id);
	
	public Skill findSkill(Long id);
	
	public Skill findSkillByName(String name);

}
