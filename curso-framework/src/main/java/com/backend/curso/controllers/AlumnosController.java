package com.backend.curso.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.Alumno.AlumnoRequestModel;
import com.backend.curso.models.Alumno.AlumnoResponseModel;
import com.backend.curso.services.AlumnosService;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
	private final AlumnosService service;

	public AlumnosController(AlumnosService service) {
		this.service = service;
	}

	//*-----------------Peticiones GET----------------- */

	@GetMapping
	public ResponseEntity<List<AlumnoResponseModel
	>> listAll() {
		return ResponseEntity.ok(service.listAll());
	}

	@GetMapping("buscarC/{curp}")
	public ResponseEntity<AlumnoResponseModel> encontrarC(@PathVariable("curp") String curp) throws Exception{
		return ResponseEntity.ok(service.findByCurp(curp));
	}

	@GetMapping("buscarNc/{numeroControl}")
	public ResponseEntity<AlumnoResponseModel> encontrarN(@PathVariable("numeroControl") String numberControl) throws Exception{
		return ResponseEntity.ok(service.findByControlNumber(numberControl));
	}


}
