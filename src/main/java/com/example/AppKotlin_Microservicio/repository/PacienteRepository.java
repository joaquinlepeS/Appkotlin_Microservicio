package com.example.AppKotlin_Microservicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AppKotlin_Microservicio.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNombre(String nombre);
    java.util.Optional<Paciente> findByEmail(String email);

}
