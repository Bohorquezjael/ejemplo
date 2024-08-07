package com.backend.curso.entities;

import java.io.Serializable;

import com.backend.curso.models.Profesor.ProfesorRequestModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profesor")
@SequenceGenerator(name = "profesor_seq", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
public class Profesor implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    private Long id;
    @Column(name = "nombre", length = 35, nullable = false)
    private String nombre;
    @Column(name = "apellido_paterno", length = 40, nullable = false)
    private String apellidoPaterno;
    @Column(name = "apellido_materno", length = 40, nullable = false)
    private String apellidoMaterno;
    @Column(name = "curp", length = 20, nullable = false)
    private String curp;

    public Profesor(ProfesorRequestModel model){
        this.nombre = model.getNombre();
        this.apellidoPaterno = model.getApellidoPaterno();
        this.apellidoMaterno = model.getApellidoMaterno();
        this.curp = model.getCurp();
    }
}