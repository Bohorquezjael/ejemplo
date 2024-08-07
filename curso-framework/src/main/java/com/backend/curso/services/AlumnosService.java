package com.backend.curso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.curso.entities.Alumno;
import com.backend.curso.models.Alumno.AlumnoRequestModel;
import com.backend.curso.models.Alumno.AlumnoResponseModel;
import com.backend.curso.repositories.AlumnosRepository;

@Service
public class AlumnosService {
    private final AlumnosRepository repository;

    @Autowired
    public AlumnosService(AlumnosRepository repository) {
        this.repository = repository;
    }

    //? Refactor a Interfaz principios ID SOLID
    public List<AlumnoResponseModel> listAll() {
        return repository.findAll().stream()
                                        .map(AlumnoResponseModel::new)
                                        .collect(Collectors.toList());
    }

    public AlumnoResponseModel findByCurp(String curp) throws Exception {
        return new AlumnoResponseModel(repository.findByCurp(curp).orElseThrow());
    }

    public AlumnoResponseModel findByNumberControl(String numberControl) throws Exception {
        return new AlumnoResponseModel(repository.findByNumeroControl(numberControl).orElseThrow());
    }

    public List<AlumnoResponseModel> findAlumnosByNombre(String nombre) {
        return repository.findAlumnsByNombre(nombre).stream()
                                                        .map(AlumnoResponseModel::new)
                                                        .collect(Collectors.toList());
    }

    public AlumnoResponseModel saveAlumno(AlumnoRequestModel alumnoModel) throws Exception {
        Alumno alumno = new Alumno(alumnoModel);
        if(!exists(alumno)){
            repository.save(alumno);
            return new AlumnoResponseModel(alumno);
        }
        throw new Exception("Ya se encuentra un alumno con los mismos datos o con la misma curp");
    }

    private boolean exists(Alumno alumno) {
        return repository.findByCurpAndNumeroControl(alumno.getCurp(), alumno.getNumeroControl()).isPresent();
    }

    public Alumno guardar(Alumno alumno) throws Exception {
        System.out.println("Que pasa aqui");
        // ! QUIEN IMPLEMENTA??
        if (repository.findByCurp(alumno.getCurp()).isPresent()) {
            throw new Exception("No puedes guardar un alumno con esa curp");
        }

        return repository.save(alumno);
    }

    public Alumno obtenerPorId(long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("El alumno no se encuentra"));
    }

    public AlumnoResponseModel obtenerModelPorId(long id) throws Exception {
        return new AlumnoResponseModel(obtenerPorId(id));
    }

    public AlumnoResponseModel guardarModel(AlumnoRequestModel model) throws Exception {
        return new AlumnoResponseModel(guardar(new Alumno(model)));
    }

}