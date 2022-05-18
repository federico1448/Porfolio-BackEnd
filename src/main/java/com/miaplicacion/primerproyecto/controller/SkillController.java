package com.miaplicacion.primerproyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miaplicacion.primerproyecto.jpa.interfaces.ISkillService;
import com.miaplicacion.primerproyecto.model.Skill;

@RequestMapping
public class SkillController {
	@Autowired
	private ISkillService iskillService;
	
	@GetMapping("/skill/getall")
	public List<Skill> getSkils(){
		return iskillService.getSkill();
	}
	
	@PostMapping("/skill/create")
	public String createSkill(@RequestBody Skill skill) {
		iskillService.saveSkill(skill);
		return "skill create successfully";
	}
	
	@DeleteMapping("/skill/delete/{id}")
	public String deleteSkill(@PathVariable Long id) {
		iskillService.deleteSkill(id);
		return "skill deleted successfully";
	}
	
	@PutMapping("/skill/edit/{id}")
	public Skill editSkill(@PathVariable Long id,
			@RequestParam("name") String nameSkill,
			@RequestParam("porcent") int porcentSkill) {
		Skill skill=iskillService.findSkill(id);
		skill.setName(nameSkill);
		skill.setPorcent(porcentSkill);
		iskillService.saveSkill(skill);
		return skill;
	}
	
}
	
	
	
	
