package com.backend.curso.models.Profesor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorRequestModel {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;
}
