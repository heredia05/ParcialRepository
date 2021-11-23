package com.examen.escuela.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequest {

	private String nombre;
	private Integer identificacion;
	private String correo;
	private Integer edad;
	
	private List<AcudientesRequest> acudientes;
}
