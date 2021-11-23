package com.examen.escuela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteResponse {

	private String nombre;
	private Integer identificacion;
	private String correo;
	private Integer edad;
}
