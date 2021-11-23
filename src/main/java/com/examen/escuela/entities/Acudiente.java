package com.examen.escuela.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Acudiente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acudiente")
	private Long id;
	@Column(name = "nombre_acudiente", length = 30)
	private String nombre;
	@Column(name = "parentesco_acudiente", length = 30)
	private String parentesco;
	@Column(name = "telefono_acudiente", length = 30)
	private Integer telefono;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Estudiante estudiante;
	
	
}
