package com.backend.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.Alumno.AlumnoRequestModel;
import com.backend.curso.models.Alumno.AlumnoResponseModel;
import com.backend.curso.services.AlumnosService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
	@Autowired
	private final AlumnosService service;

	//*-----------------Peticiones GET----------------- */

	@GetMapping
	public ResponseEntity<List<AlumnoResponseModel
	>> listAll() {
		List<AlumnoResponseModel> alumnos = service.listAll();
		if(alumnos.isEmpty()){
			log.warn("No hay datos para mostrar");
			return ResponseEntity.noContent().build();
		}
		log.info("{} Alumnos mostrados", alumnos.size());
		return ResponseEntity.ok(alumnos);
	}

	@GetMapping("curp/{curp}")
	public ResponseEntity<AlumnoResponseModel> alumnoByCurp(@PathVariable("curp") String curp){
		try{
			AlumnoResponseModel alumno = service.findByCurp(curp);
			log.info("Alumno encontrado con la curp {}", curp);
			return ResponseEntity.status(418).body(alumno);
		}catch(Exception e){
			log.warn("No se encontró el alumno con CURP {}", curp);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("numero_control/{numeroControl}")
	public ResponseEntity<AlumnoResponseModel> alumnoByNumberControl(@PathVariable("numeroControl") String numberControl){
		try{
			AlumnoResponseModel alumno = service.findByNumberControl(numberControl);
			log.info("Alumno encontrado con el número de control {}", numberControl);
			return ResponseEntity.ok(alumno);
		}catch(Exception e){
			log.warn("alumno no encontrado con el numero de control: {}", numberControl);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("nombre/{nombre}")
	public ResponseEntity<List<AlumnoResponseModel>> alumnosByNombre(@PathVariable("nombre") String nombre){
		List<AlumnoResponseModel> alumnos = service.findAlumnosByNombre(nombre);
		if(alumnos.isEmpty()){
			log.warn("No hay alumnos con el nombre: {}", nombre);
			return ResponseEntity.noContent().build();
		}
		log.info("Se encontraron {} alumnos con el nombre {}", alumnos.size(), nombre);
		return ResponseEntity.ok(alumnos);
	}

	//*-----------------Peticiones POST----------------- */

	@PostMapping("guardarAlumno")
	public ResponseEntity<AlumnoResponseModel> saveAlumn(@RequestBody AlumnoRequestModel alumno){
		try{
			AlumnoResponseModel alumnoResponse = service.saveAlumno(alumno);
			log.info("Alumno guardado con éxito");
			return ResponseEntity.status(201).body(alumnoResponse);
		}catch(Exception e){
			log.error("Error al guardar el alumno: {}", e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
}