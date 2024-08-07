package com.backend.curso.repositories;

import com.backend.curso.entities.Alumno;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//? OUR CRUD IMPLEMENTATION
@Repository
public interface AlumnosRepository extends CrudRepository<Alumno, Long> {
    public Optional<Alumno> findByCurp(String curp);

    // @Query("SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    public Optional<Alumno> findByNombre(String nombre);

	public Optional<Alumno> findByNumeroControl(String numberControl);
}
