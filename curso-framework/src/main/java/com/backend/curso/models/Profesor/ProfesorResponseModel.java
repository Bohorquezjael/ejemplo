package com.backend.curso.models.Profesor;

import com.backend.curso.entities.Profesor;


public class ProfesorResponseModel {
    //? REFACTOR A RECORD?
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;

    public ProfesorResponseModel(Profesor profesor){
        this.nombre = profesor.getNombre();
        this.apellidoPaterno = profesor.getApellidoPaterno();
        this.apellidoMaterno = profesor.getApellidoMaterno();
        this.curp = profesor.getCurp();
    }

}
