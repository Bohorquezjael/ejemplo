package com.backend.curso.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import com.backend.curso.entities.Alumno;
import com.backend.curso.models.Alumno.AlumnoRequestModel;
import com.backend.curso.models.Alumno.AlumnoResponseModel;
import com.backend.curso.repositories.AlumnosRepository;

@Service
public class AlumnosService {
    private final AlumnosRepository repository;

    public AlumnosService(AlumnosRepository repository) {
        this.repository = repository;
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

    public List<AlumnoResponseModel> listAll() {
        List<AlumnoResponseModel> alumns = new ArrayList<>();
        Iterator<Alumno> lists = repository.findAll().iterator();
        while(lists.hasNext()){
            alumns.add(new AlumnoResponseModel(lists.next()));
        }
        return alumns;
    }

    public AlumnoResponseModel findByCurp(String curp) throws Exception {
        return new AlumnoResponseModel(modelByCurp(curp));
    }

    private Alumno modelByCurp(String curp) {
        return repository.findByCurp(curp).orElseThrow();
    }

    public AlumnoResponseModel findByControlNumber(String numberControl) throws Exception {
        return new AlumnoResponseModel(repository.findByNumeroControl(numberControl).orElseThrow(() -> new Exception("No encontrado")));
    }
}
