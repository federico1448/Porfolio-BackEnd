package com.example.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long>{
	Education findByName(String name);
}
