package com.backend.curso.repositories;

import com.backend.curso.entities.Alumno;
import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

//? OUR CRUD IMPLEMENTATION
@Repository
public interface AlumnosRepository extends ListCrudRepository<Alumno, Long> {
    public Optional<Alumno> findByCurp(String curp);

    // @Query("SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    public Optional<Alumno> findByNombre(String nombre);

	public Optional<Alumno> findByNumeroControl(String numberControl);
    
    public List<Alumno> findAlumnsByNombre(String nombre);

    public Optional<Alumno> findByCurpAndNumeroControl(String curp, String numberControl);
}
