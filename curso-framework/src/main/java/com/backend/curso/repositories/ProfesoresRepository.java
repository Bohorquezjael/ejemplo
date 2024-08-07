package com.backend.curso.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.curso.entities.Profesor;

@Repository
public interface ProfesoresRepository extends CrudRepository<Profesor, Long> {
}