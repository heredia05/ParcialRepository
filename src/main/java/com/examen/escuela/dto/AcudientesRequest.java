package com.examen.escuela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcudientesRequest {

	private String nombre;
	private String parentesco;
	private Integer telefono;
}
