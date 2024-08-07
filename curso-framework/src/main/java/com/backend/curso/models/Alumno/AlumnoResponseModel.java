package com.backend.curso.models.Alumno;

import com.backend.curso.entities.Alumno;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoResponseModel {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroControl;
    private String curp;

    public AlumnoResponseModel(Alumno alumno) {
        this.id = alumno.getId();
        this.nombre = alumno.getNombre();
        this.apellidoPaterno = alumno.getApellidoPaterno();
        this.apellidoMaterno = alumno.getApellidoMaterno();
        this.curp = alumno.getCurp();
        this.numeroControl = alumno.getNumeroControl();
    }
}