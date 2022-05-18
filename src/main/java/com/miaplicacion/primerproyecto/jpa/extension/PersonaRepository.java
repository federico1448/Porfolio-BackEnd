package com.miaplicacion.primerproyecto.jpa.extension;

import com.miaplicacion.primerproyecto.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{

}
