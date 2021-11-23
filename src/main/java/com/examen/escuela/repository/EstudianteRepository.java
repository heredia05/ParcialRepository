package com.examen.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.escuela.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
