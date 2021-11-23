package com.examen.escuela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.escuela.dto.EstudianteActuRequest;
import com.examen.escuela.dto.EstudianteRequest;
import com.examen.escuela.dto.EstudianteResponse;
import com.examen.escuela.entities.Estudiante;
import com.examen.escuela.service.EstudianteService;
import com.examen.escuela.util.EntidadToConverter;

@RestController
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private EntidadToConverter converter;

	@GetMapping(value = "estudiante")
	public ResponseEntity<List<EstudianteResponse>> listarEstudiantes() {
		List<Estudiante> listaEstudiantes = estudianteService.listarEstudiantes();
		return new ResponseEntity<List<EstudianteResponse>>(converter.convertirEstudiante(listaEstudiantes), HttpStatus.OK);
	}

	@GetMapping(value = "estudiante/{id}")
	public ResponseEntity<EstudianteResponse> estudianteXId(@PathVariable Long id) {
		Estudiante estudiante = estudianteService.buscarEstudianteXId(id);
		return new ResponseEntity<EstudianteResponse>(converter.convertirEstudiante(estudiante), HttpStatus.OK);
	}

	
	@DeleteMapping(value= "estudiante/{id}")
	public ResponseEntity<Boolean> borrarEstudianteXid(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(estudianteService.eliminarEstudianteXId(id),HttpStatus.OK);
	}
	
	@PutMapping(value= "estudiante/{id}")
	public ResponseEntity<EstudianteResponse> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteActuRequest estudianteRequest){
		Estudiante estudiante = estudianteService.actualizarEstudiante(estudianteRequest, id);
		return new ResponseEntity<EstudianteResponse>(converter.convertirEstudiante(estudiante),HttpStatus.OK);
	}
	
	@PostMapping(value = "estudiante")
	public ResponseEntity<EstudianteResponse> crearEstudiante (@RequestBody EstudianteRequest estudianteRequest){
		Estudiante estudiante = estudianteService.crearEstudiante(estudianteRequest);
		if(estudiante == null) {
			return new ResponseEntity<EstudianteResponse>(converter.convertirEstudiante(estudiante), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<EstudianteResponse>(converter.convertirEstudiante(estudiante), HttpStatus.CREATED);
	}
}
