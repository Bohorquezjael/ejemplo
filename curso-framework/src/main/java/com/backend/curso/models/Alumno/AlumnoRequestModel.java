package com.backend.curso.models.Alumno;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequestModel {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroControl;
    private String curp;
}