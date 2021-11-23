package com.examen.escuela.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudiante")
	private Long id;
	@Column(name = "nombre_estudiante", length = 30)
	private String nombre;
	@Column(name = "identificacion_estudiante")
	private Integer identificacion;
	@Column(name = "correo_estudiante")
	private String correo;
	@Column(name = "edad_estudiante")
	private Integer edad;
	@Column(name = "estado_estudiante")
	private Boolean isActivo; 
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estudiante")
	private List<Acudiente> acudientes;
}
