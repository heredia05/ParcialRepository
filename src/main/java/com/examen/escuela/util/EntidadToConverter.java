package com.examen.escuela.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examen.escuela.dto.EstudianteResponse;
import com.examen.escuela.entities.Estudiante;

@Component
public class EntidadToConverter {

	@Autowired
	private ModelMapper modelMaper;
	
	public EstudianteResponse convertirEstudiante(Estudiante estudiante) {
		return modelMaper.map(estudiante, EstudianteResponse.class);
	}
	
	public List<EstudianteResponse> convertirEstudiante(List<Estudiante> estudiantes) {
		return estudiantes.stream().map(estudiante-> convertirEstudiante(estudiante)).collect(Collectors.toList());
	}
	
}
